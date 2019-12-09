package com.ccc.my.project.web.api.dao;

import com.ccc.my.project.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ccc
 * @create 2019-11-12-19:05
 */
@Repository
public interface TbContentDao {
    /**
     * 根据类别ID查询内容列表
     * @param tbContent
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
