package com.ccc.my.project.web.admin.web.interceptor;

import com.ccc.my.project.commons.constant.ConstantUtils;
import com.ccc.my.project.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * 越登陆请求拦截器
 *
 * @author ccc
 * @create 2019-10-25 21:50
 */
public class loginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser user = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
        //未登录拦截，强制跳转至登陆界面
        if (user == null){
            httpServletResponse.sendRedirect("/login");
        }
        //放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}