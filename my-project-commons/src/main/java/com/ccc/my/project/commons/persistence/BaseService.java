package com.ccc.my.project.commons.persistence;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.dto.PageInfo;

import java.util.List;

/**
 * 所有业务逻辑层的基类
 * @author ccc
 * @create 2019-11-05 12:17
 */
public interface BaseService <T extends BaseEntity> {
    /**
     * 用户信息展示
     * @return
     */
     public List<T> selectAll();

    /**
     * 添加用户
     * @param entity
     * @return
     */
    BaseResult save(T entity);

    /**
     * 删除用户
     * @param id
     */
    void delete(Long id);

    /**
     * 按照id查询数据信息
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    PageInfo<T> page(int start, int length, int draw, T entity);

    /**
     * 查询总数
     */
    int count(T entity);

    /**
     * 更新
     */
    void update(T entity);
}
