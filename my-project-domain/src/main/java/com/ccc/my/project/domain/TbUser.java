package com.ccc.my.project.domain;

import com.ccc.my.project.commons.persistence.BaseEntity;
import com.ccc.my.project.commons.utils.RegexpUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;


/**
 * @author ccc
 * @create 2019-10-25 10:38
 */
//lombok的封装注解（getter和setter）
@Data
@EqualsAndHashCode(callSuper = true)
public class TbUser extends BaseEntity {

    /*在commons里面有一个BaseEntity的实体类基类，所以公共属性 id，created,updated,属于基类中的属性*/
    @Length(min = 2,max = 20,message = "用户名长度必须在2-20之间！")
    private String username;

    @JsonIgnore
    @Length(min = 5,max = 15,message = "密码长度请设置5-15位之间！")
    private String password;

    //工具类RegexpUtils.PHONE中的正则表达式验证
    @Pattern(regexp = RegexpUtils.PHONE,message = "手机格式输入有误！")
    private String phone;

    @Pattern(regexp = RegexpUtils.EMAIL,message = "邮箱格式输入有误！")
    private String email;

}