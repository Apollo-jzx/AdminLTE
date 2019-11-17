package com.ccc.my.project.web.admin.service.impl;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.validator.BeanValidator;
import com.ccc.my.project.domain.TbContentCategory;
import com.ccc.my.project.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import com.ccc.my.project.web.admin.dao.TbContentCategoryDao;
import com.ccc.my.project.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
/**
 * @author ccc
 * @create 2019-11-02 10:37
 */
@Service
@Transactional(readOnly = true)
public class TbContentCategoryServiceImpl extends AbstractBaseTreeServiceImpl<TbContentCategory,TbContentCategoryDao> implements TbContentCategoryService {
    @Autowired
    private TbContentCategoryDao tbContentCategoryDao;


    @Override
    @Transactional(readOnly = false)
    public BaseResult save(TbContentCategory entity) {
        String validator = BeanValidator.validator(entity);
        //验证通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //验证不通过
        else {
            /*修改更新时间*/
            entity.setUpdated(new Date());

            TbContentCategory parent = entity.getParent();
            //如果没有选择父级点则默认设为根目录
            if (parent == null || parent.getId()== null) {
                parent.setId(0L);
            }

            entity.setUpdated(new Date());
            //新增
            if (entity.getId() == null) {
                entity.setCreated(new Date());
                entity.setIsParent(false);

                //判断当前新增有没有父级节点
                if (parent.getId() != 0L) {
                    TbContentCategory currentCategoryParent = getById(parent.getId());
                    if (currentCategoryParent != null) {
                        //为父级节点设置isParent为true
                        currentCategoryParent.setIsParent(true);
                        update(currentCategoryParent);

                    }
                }
                //父级节点为0表示为根目录
                else {
                    //根目录一定是父级目录
                    entity.setIsParent(true);

                }

                //新增
                tbContentCategoryDao.insert(entity);

            }
            //修改
            else {
                tbContentCategoryDao.update(entity);
            }
            /*用户信息新增或者修改成功，则给操作成功提示*/
            return BaseResult.success("内容信息保存成功！");
        }
    }
}
