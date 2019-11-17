package com.ccc.my.project.web.admin.abstracts;

import com.ccc.my.project.commons.dto.PageInfo;
import com.ccc.my.project.commons.persistence.BaseDao;
import com.ccc.my.project.commons.persistence.BaseEntity;
import com.ccc.my.project.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ccc
 * @create 2019-11-10-0:10
 */
public abstract class AbstractBaseServiceImpl<T extends BaseEntity,D extends BaseDao<T>> implements BaseService<T> {

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
     * 删除用户信息
     * @param id
     */
    @Override
    public void delete(Long id){
        dao.delete(id);
    }

    /**
     * 根据id获取信息
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
    public void update(T entity){
        dao.update(entity);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteMulti(String[] ids){
        dao.deleteMulti(ids);
    }

    /**
     * 查询总条数
     * @param entity
     * @return
     */
    @Override
    public int count(T entity){
        return dao.count(entity);
    }

    /**
     * 分页查询
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    @Override
    public PageInfo<T> page(int start, int length,int draw,T entity) {
        int count = count(entity);
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("pageParams",entity);

        PageInfo<T> pageInfo = new PageInfo();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(dao.page(params));

        return pageInfo;
    }
}
