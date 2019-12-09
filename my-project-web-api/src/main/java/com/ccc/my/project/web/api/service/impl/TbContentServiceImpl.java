package com.ccc.my.project.web.api.service.impl;

import com.ccc.my.project.domain.TbContent;
import com.ccc.my.project.domain.TbContentCategory;
import com.ccc.my.project.web.api.dao.TbContentDao;
import com.ccc.my.project.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ccc
 * @create 2019-11-15-13:24
 */
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectByCategoryId(Long categoryId) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(categoryId);
        TbContent tbContent = new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);
        return tbContentDao.selectByCategoryId(tbContent);
    }
}
