package com.ccc.my.project.web.ui.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * <a>Author<a>
 * <a>Description<a>
 *
 * @Author ccc
 * @Date 2019/12/10 16:46
 * @Version 1.0.0
 */
@Data
public class TbUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
}
