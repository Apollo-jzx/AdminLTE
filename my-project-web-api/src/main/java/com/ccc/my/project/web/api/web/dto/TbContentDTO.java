package com.ccc.my.project.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 内容数据传输对象
 * 传输我们在请求过程中只需要请求到的数据对象
 * @author ccc
 * @create 2019-11-13-21:14
 */
@Data
public class TbContentDTO implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
