package com.ccc.my.project.web.api.service;

import com.ccc.my.project.domain.TbContent;

import java.util.List;

/**
 * @author ccc
 * @create 2019-11-13-21:15
 */
public interface TbContentService {
    List<TbContent> selectByCategoryId(Long categoryId);
}
