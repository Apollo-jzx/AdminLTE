package com.ccc.my.project.web.ui.interceptor;

import com.ccc.my.project.web.ui.constant.SystemConstants;
import com.ccc.my.project.web.ui.dto.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <a>Title:LoginInterceptor</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *登录拦截器
 * @Author ccc
 * @Date 2019/12/24 12:19
 * @Version 1.0.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    //请求之前的操作 判断session会话中有没有东西
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        TbUser tbUser = (TbUser) request.getSession().getAttribute(SystemConstants.SESSION_USER_KEY);
        //未登录状态 tbUsr为空 就放行
        if (tbUser == null){
            return true;
        }
        //登录则拦截 重定向回首页
        else {
            response.sendRedirect("/index");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
