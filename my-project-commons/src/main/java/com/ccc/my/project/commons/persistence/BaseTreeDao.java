package com.ccc.my.project.commons.persistence;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.dto.PageInfo;

import java.util.List;

/**
 * 通用的树形结构接口
 * @author ccc
 * @create 2019-11-09-17:38
 */
public interface BaseTreeDao <T extends BaseEntity>{
    /**
     * 用户信息展示
     * @return
     */
    List<T> selectAll();

    /**
     * 单删
     */
    void delete(String[] ids);

    /**
     * 按照id查询数据信息
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 更新
     */
    void update(T entity);

    /**
     * 新增
     */
    void insert(T entity);

    /**
     * 根据父级节点ID查询所有子节点
     * @param Pid
     * @return
     */
    List<T> selectByParentId(Long Pid);
}
