package com.ccc.my.project.commons.dto;

import com.ccc.my.project.commons.persistence.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author ccc
 * @create 2019-11-08-16:12
 */
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
