package com.ccc.my.project.web.api.web.dto;

import com.ccc.my.project.commons.utils.RegexpUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * <a>Author<a>
 * <a>Description<a>
 *
 * @Author ccc
 * @Date 2019/12/10 18:40
 * @Version 1.0.0
 */
@Data
public class TbUserDto {
    private Long id;
    private String username;

    @JsonIgnore
    private String password;
    private String phone;
    private String email;

}
