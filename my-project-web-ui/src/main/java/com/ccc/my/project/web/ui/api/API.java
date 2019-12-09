package com.ccc.my.project.web.ui.api;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * API常量
 * @author ccc
 * @create 2019-12-09-16:14
 */
public class API {
    /**
     * 主机地址
     */
    public static final String HOST = "http://localhost:8081/api/v1";

    /**
     * 请求首页轮播图接口
     */
    public static final String API_CONTENTS_PPT = HOST +"/contents/ppt";

    /**
     * 请求用户登录接口
     */
    public static final String API_USERS_LOGIN = HOST + "/users/login";
}
