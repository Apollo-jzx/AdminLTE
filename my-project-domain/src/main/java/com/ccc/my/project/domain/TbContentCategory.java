package com.ccc.my.project.domain;

import com.ccc.my.project.commons.persistence.BaseTreeEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 分类的管理
 * @author ccc
 * @create 2019-11-02 10:27
 */
@Data
public class TbContentCategory extends BaseTreeEntity {

    @Length(min = 1,max = 20,message = "分类名称必须介于1 - 20位之间！")
    private String name;
    private Integer status;

    @NotNull(message = "排序不能为空！")
    private Integer sortOrder;
    //别名 ，因为前台在创建的时候需要isParent字段的额信息
    //@JsonProperty(value = "isParent")
    private Boolean isParent;
    private TbContentCategory parent;

}
