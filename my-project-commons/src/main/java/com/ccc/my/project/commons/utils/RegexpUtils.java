package com.ccc.my.project.commons.utils;

/**
 * @author ccc
 * @create 2019-11-08-16:15
 * 正则表达式的验证
 */
public class RegexpUtils {
    /*
     * 验证手机号正则表达式
     * */
    public static final String PHONE = "^[1](([3][0-9])|([4][5,7,9])|([5][0-9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";

    /*
     * 验证邮箱地址正则表达式
     * */
    public static  final String EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /*
     * 验证手机号
     * */
    public static boolean checkPhone(String phone) {
        return phone.matches(PHONE);
    }

    /*
     * 验证邮箱
     * */
    public static boolean checkEmail(String email) {
        return email.matches(EMAIL);
    }
}
