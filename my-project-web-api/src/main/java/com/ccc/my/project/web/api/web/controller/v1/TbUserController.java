package com.ccc.my.project.web.api.web.controller.v1;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.domain.TbUser;
import com.ccc.my.project.web.api.service.TbUserService;
import com.ccc.my.project.web.api.web.dto.TbUserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Author<a>
 * <a>Description<a>
 *
 * @Author ccc
 * @Date 2019/12/10 18:39
 * @Version 1.0.0
 */
@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * 登录
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login (TbUser tbUser) {
        TbUser user = tbUserService.login(tbUser);
        if (user == null) {
            return BaseResult.fail("用户名或密码输入错误，请重新输入！");
        }
        else {
            TbUserDto dto = new TbUserDto();
            BeanUtils.copyProperties(user,dto);
             return BaseResult.success("登录成功！",dto);
        }
    }
}
