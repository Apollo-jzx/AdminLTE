package com.ccc.my.project.web.admin.abstracts;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.dto.PageInfo;
import com.ccc.my.project.commons.persistence.BaseEntity;
import com.ccc.my.project.commons.persistence.BaseTreeEntity;
import com.ccc.my.project.commons.persistence.BaseTreeService;
import com.ccc.my.project.domain.TbContentCategory;
import com.ccc.my.project.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ccc
 * @create 2019-11-10-12:02
 */
public abstract class AbstractBaseTreeController<T extends BaseTreeEntity,S extends BaseTreeService<T>> {
    /*树形结构的contentCategoryController不需要分页，所以在创建一个AbstractBaseTreeController，用来继承AbstractBaseController父类中的所欲方法
    在控制器contentCategoryController中不需要分页PageInfo所以在此重写，并返回return null;在contentCategoryController
    控制器继承之后就会重写除分页之外AbstractBaseController中所有方法。*/
/*    @Override
    public PageInfo page(HttpServletRequest request, BaseEntity entity) {
        return null;
    }*/
    @Autowired
    protected S service;

    /**
     * 跳转列表页
     *
     * @param model
     * @return
     */
    public abstract String list(Model model);

    /**
     * 跳转表单页面
     *
     * @param entity
     * @return
     */
    public abstract String form(T entity);

    /**
     * 保存
     * @param entity
     * @param redirectAttributes
     * @param model
     * @return
     */
    public abstract String save(T entity , RedirectAttributes redirectAttributes, Model model);

    /**
     * 删除
     * @param ids
     * @return
     */
    public abstract BaseResult delete(String ids);

    /**
     * 树形结构
     * @param id
     * @return
     */
    public abstract List<T> treeData(Long id);

    /**
     * 遍历排序
     * @param sourceList
     * @param targetList
     * @param parentId
     */
    protected void sortList(List<T> sourceList,List<T> targetList,Long parentId) {
        for (T sourceEntity : sourceList) {
            if (sourceEntity.getParent().getId().equals(parentId)) {
                targetList.add(sourceEntity);

                if (sourceEntity.getIsParent()) {
                    for (T currentEntity : sourceList) {
                        if (currentEntity.getParent().getId().equals(sourceEntity.getId())) {
                            sortList(sourceList,targetList,sourceEntity.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
