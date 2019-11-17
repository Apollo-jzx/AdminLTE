package com.ccc.my.project.commons.persistence;

import com.ccc.my.project.commons.dto.BaseResult;

import java.util.List;

/**
 * @author ccc
 * @create 2019-11-09-17:43
 */
public interface BaseTreeService <T extends BaseEntity> {
    /**
     * 用户信息展示
     * @return
     */
    List<T> selectAll();

    /**
     * 添加用户
     * @param entity
     * @return
     */
    BaseResult save(T entity);

    /**
     * 单删
     */
    void delete(Long id);

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
     * 根据父级节点ID查询所有子节点
     * @param Pid
     * @return
     */
    List<T> selectByParentId(Long Pid);
}
