package com.ccc.my.project.commons.persistence;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ccc
 * @create 2019-11-10-12:27
 */
@Data
public abstract class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    private T parent;
    private Boolean isParent;
}
