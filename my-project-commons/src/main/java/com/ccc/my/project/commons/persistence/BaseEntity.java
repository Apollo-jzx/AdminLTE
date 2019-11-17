package com.ccc.my.project.commons.persistence;

import java.io.Serializable;
import java.util.Date;
/**
 * @author ccc
 * @create 2019-11-08-16:14
 */
public class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}