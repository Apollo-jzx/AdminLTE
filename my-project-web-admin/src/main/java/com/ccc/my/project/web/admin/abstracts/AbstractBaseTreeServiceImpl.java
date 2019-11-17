package com.ccc.my.project.web.admin.abstracts;

import com.ccc.my.project.commons.persistence.BaseEntity;
import com.ccc.my.project.commons.persistence.BaseTreeDao;
import com.ccc.my.project.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ccc
 * @create 2019-11-09-21:57
 */
public abstract class  AbstractBaseTreeServiceImpl<T extends BaseEntity,D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    @Autowired
    protected D dao;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<T> selectAll(){
        return dao.selectAll();
    }

    /**
     * 删除
     * @param id
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id){
        dao.delete(new String[]{String.valueOf(id)});
    }

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    @Override
    public T getById(Long id){
        return dao.getById(id);
    }

    /**
     * 更新
     * @param entity
     */
    @Override
    @Transactional(readOnly = false)
    public void update(T entity){
        dao.update(entity);
    }

    /**
     * 根据父节点id查询所有子节点
     * @param id
     * @return
     */
    @Override
    public List<T> selectByParentId(Long id){
        return dao.selectByParentId(id);
    }
}
