package com.ccc.my.project.web.admin.service.impl;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.dto.PageInfo;
import com.ccc.my.project.commons.utils.RegexpUtils;
import com.ccc.my.project.commons.validator.BeanValidator;
import com.ccc.my.project.domain.TbContent;
import com.ccc.my.project.domain.TbUser;
import com.ccc.my.project.web.admin.abstracts.AbstractBaseServiceImpl;
import com.ccc.my.project.web.admin.dao.TbContentDao;
import com.ccc.my.project.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ccc
 * @create 2019-11-03 14:45
 */
@Service
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent,TbContentDao> implements TbContentService {

    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        //验证通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //验证不通过
        else {
            /*修改更新时间*/
            tbContent.setUpdated(new Date());

            /*用户新增，注册*/
            if (tbContent.getId() == null) {
                /*注册时间*/
                tbContent.setCreated(new Date());
                /*新增用户*/
                dao.insert(tbContent);
            }

            /*用户信息修改*/
            else {
                update(tbContent);
            }
            /*用户信息新增或者修改成功，则给操作成功提示*/
            return BaseResult.success("内容信息保存成功！");
        }
    }
}
