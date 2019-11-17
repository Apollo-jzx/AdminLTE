package com.ccc.my.project.commons.dto;

import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * @author ccc
 * @create 2019-11-08-16:11
 */
public class BaseResult implements Serializable {
    /*将状态信息号码常量提取出来封装*/
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    //状态信息码
    private int status;
    //信息
    private String message;

    private Object data;

    /*
     * 执行成功的信息
     * */
    public static BaseResult success(){

        return BaseResult.createResult(STATUS_SUCCESS,"成功", null);
    }

    /*
     * 成功执行操作过程中返回信息 方法重载
     * */
    public static BaseResult success(String message){

        return BaseResult.createResult(STATUS_SUCCESS,message,null);
    }

    public  static BaseResult success(String message,Object data){
        return BaseResult.createResult(STATUS_SUCCESS,message,data);
    }

    /*
     * 执行失败的信息
     * */
    public static BaseResult fail(){

        return BaseResult.createResult(STATUS_FAIL,"失败",null);
    }

    /*
     * 失败执行操作过程中返回信息 方法重载
     * */
    public static BaseResult fail(String message){

        return BaseResult.createResult(STATUS_FAIL,message,null);
    }

    /*
     * 失败可能状态码和信息有多种
     * */
    public static BaseResult fail(int status,String message){

        return BaseResult.createResult(status,message,null);
    }
/*
        讲方法封装，继承 达到面向对象编程三大特性 封装继承多态。
        重构方法
        public static BaseResult success(){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(200);
        baseResult.setMessage("成功");
        return baseResult;
    }

    public static  BaseResult success(String message){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(200);
        baseResult.setMessage("message");
        return baseResult;
    }

    public  static BaseResult fail(){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(500);
        baseResult.setMessage("失败");
        return baseResult;
    }*/

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {

        this.status = status;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /*提取方法 重构 （事不过三，三则重构）*/
    private  static  BaseResult createResult(int status,String message,Object data){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return baseResult;
    }
}

