package com.ccc.my.project.web.ui.controller;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.utils.HttpClientUtils;
import com.ccc.my.project.commons.utils.MapperUtils;
import com.ccc.my.project.web.ui.api.API;
import com.ccc.my.project.web.ui.api.UsersApi;
import com.ccc.my.project.web.ui.constant.SystemConstants;
import com.ccc.my.project.web.ui.dto.TbUser;
import org.apache.http.HttpRequest;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <a>Author<a>
 * <a>Description<a>
 *
 * @Author ccc
 * @Date 2019/12/10 16:32
 * @Version 1.0.0
 */
@Controller
public class loginController {

    /**
     * 跳转首页
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login () {
        return "login";
    }

    /**
     * 登录
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login (TbUser tbUser, Model model, HttpServletRequest request) throws Exception {
        TbUser user = usersApi(tbUser);

        if (user == null) {
            model.addAttribute("baseResult",BaseResult.fail("用户名或密码错误，请重新输入！"));
            return "login";
        }
//        登录成功
//        要将信息放在会话中，所以应该放在requst中而不是model
        else {
//            model.addAttribute("tbUser",user);
            //将用户信息放入session中
            request.getSession().setAttribute(SystemConstants.SESSION_USER_KEY,user);
            //然后重定向回首页
            return "redirect:/login";
        }

    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout (HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index";
    }

    //定义用户登录接口
    private static TbUser  usersApi (TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();

        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);

        return user;
    }
}
