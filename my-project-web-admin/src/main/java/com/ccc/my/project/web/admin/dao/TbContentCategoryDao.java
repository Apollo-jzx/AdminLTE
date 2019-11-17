package com.ccc.my.project.web.admin.dao;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.persistence.BaseDao;
import com.ccc.my.project.commons.persistence.BaseTreeDao;
import com.ccc.my.project.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ccc
 * @create 2019-11-02 10:35
 */
@Repository
public interface TbContentCategoryDao extends BaseTreeDao<TbContentCategory> {
}
