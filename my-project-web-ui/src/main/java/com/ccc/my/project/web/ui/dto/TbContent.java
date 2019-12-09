package com.ccc.my.project.web.ui.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * @author ccc
 * @create 2019-11-30-17:45
 */
@Data
public class TbContent implements Serializable {
    private  Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;

}
