package com.ccc.my.project.web.admin.service.impl;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.validator.BeanValidator;
import com.ccc.my.project.domain.TbUser;
import com.ccc.my.project.web.admin.abstracts.AbstractBaseServiceImpl;
import com.ccc.my.project.web.admin.dao.TbUserDao;
import com.ccc.my.project.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * @author ccc
 * @create 2019-10-25 14:19
 */
@Service
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser,TbUserDao> implements TbUserService {
    /*
     * 用户登陆
     * */
    @Override
    public TbUser login(String email,String password){
        /*根据用户输入邮箱在查询出结果*/
        TbUser tbUser = dao.login(email);
        /*如果存在该邮箱信息，则再进行用户密码比对*/
        if (tbUser != null){
            /*如果输入密码与数据库中密码相同，则登陆成功*/
            String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
            if(pwd.equals(tbUser.getPassword())){
                return tbUser;
            }
            /*否则失败*/
        }
        return  null;
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        //验证不通过
        if (validator == null) {
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            /*修改更新时间*/
            tbUser.setUpdated(new Date());

            /*用户新增，注册*/
            if (tbUser.getId() == null) {
                System.out.println("新增=========================");
                /*密码盐值加密*/
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                /*注册时间*/
                tbUser.setCreated(new Date());
                /*新增用户*/
                dao.insert(tbUser);
            }

            /*用户信息修改*/
            else{
                //编辑时如果没有修改密码则使用原密码
                if (StringUtils.isBlank(tbUser.getPassword())){
                    TbUser oldTbUser = getById(tbUser.getId());
                    tbUser.setPassword(oldTbUser.getPassword());
                }
                //验证密码长度
                else{
                    //验证密码是否符合密码规则，密码长度介于6-20位之间
                    if (StringUtils.length(tbUser.getPassword()) < 6 || StringUtils.length(tbUser.getPassword()) > 20) {
                        return BaseResult.fail("输入有误，密码长度必须介于6-20位之间！");
                    }
                    tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                }
                update(tbUser);
                System.out.println("修改=========================");
            }
            /*用户信息新增或者修改成功，则给操作成功提示*/
            return BaseResult.success("用户信息保存成功！");
        }
    }
    }

    /*
     * 用户新增以及用户信息修改
     * */


