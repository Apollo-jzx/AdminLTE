package com.ccc.my.project.web.admin.web.controller;

import com.ccc.my.project.commons.constant.ConstantUtils;
import com.ccc.my.project.domain.TbUser;
import com.ccc.my.project.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author ccc
 * @create 2019-10-25 14:27
 */
@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;

    /*
     *跳转到登陆页面
     *
     * "","login" 请求为空或者login都会跳到登陆页面
     */
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login(){

        return "login";
    }

    /*
     *登陆逻辑
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
        public String login(@RequestParam(required = true) String email,
                        @RequestParam(required = true) String password,
                        HttpServletRequest request, Model model){
       TbUser tbUser= tbUserService.login(email,password);

        /*登陆成功*/
        if (tbUser == null){
            model.addAttribute("message","用户名或密码错误");
            return login();
        }
        /*登陆失败*/
        else {
            request.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "redirect:/main";
        }
    }

    /*
    * 注销
    * */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
        public String logout(HttpServletRequest request){
            request.getSession().invalidate();
            return login();
        }

}
