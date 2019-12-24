package com.ccc.my.project.web.ui.api;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.utils.HttpClientUtils;
import com.ccc.my.project.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Author<a>
 * <a>Description<a>
 *
 * @Author ccc
 * @Date 2019/12/10 22:56
 * @Version 1.0.0
 */
public class UsersApi {
/*    public static BaseResult login (TbUser tbUser) {
        //因为要携带参数，所有直接用format封装整个链接，利用 %s 占位符
        //因为这样传输的话 password就会在请求路径里面暴露出来，所以还是需要用POST请求传输
        *//*String s = HttpClientUtils.doGet(String.format("%s?username=%s&password=%s"));*//*

        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));

        *//*因为在HttpClientUtils.doPost中装载的是一个可变参数，可变参数是一个数组，但是这里param是一个集合
          所以需要集合转数组，集合转数组的方法是 .toArray 但是需要告诉它是什么数组， 告诉它是
          BasicNameValuePair数组，但是它需要泛型，需要泛型大小 所以就是 params.size()的大小
          这样就将集合转数组了，获取的是一个json的数组
                *//*
        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        System.out.println(json);

        return null;
    }*/
}
