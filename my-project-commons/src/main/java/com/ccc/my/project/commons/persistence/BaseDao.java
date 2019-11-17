package com.ccc.my.project.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * 所有数据访问层的分类
 * @author ccc
 * @create 2019-11-05 12:11
 */
public interface BaseDao <T extends BaseEntity>{
    /**
     * 查询全部数据
     * @return
     */
    List<T> selectAll();


    /**
     * 添加
     * @param entity
     */
    void insert(T entity);

    /**
     * 删除用户
     * @param id
     */
    void delete(Long id);

    /**
     * 信息修改
     * @param entity
     */
    void update(T entity);

    /**
     * id查询
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 批量删除
     * @param ids：批量删除的数组
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param :  start:记录数,开始的位置. length:每页需要展示的记录数
     * @param ： params需要两个参数：start记录开始的位置，  length，记录每页需要展示的数据条数
     * @return
     */
    List<T> page(Map<String,Object> params);

    /**
     * 查询数据总数
     */
    int count(T entity);
}