package com.ccc.my.project.web.admin.web.controller;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.domain.TbContentCategory;
import com.ccc.my.project.web.admin.abstracts.AbstractBaseTreeController;
import com.ccc.my.project.web.admin.service.TbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * 类容管理
 * @author ccc
 * @create 2019-11-02 10:38
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController extends AbstractBaseTreeController<TbContentCategory,TbContentCategoryService> {

    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id) {
        TbContentCategory tbContentCategory = null;
        if (id != null) {
            tbContentCategory = service.getById(id);
        }
        else {
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }

    @Override
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = service.selectAll();

        //排序
        sortList(sourceList,targetList,0L);

        model.addAttribute("tbContentCategories",targetList);
        return "contentcategoryInfo";
    }

    /**
     * 跳转表单
     * @param tbContentCategory
     * @return
     */
    @Override
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(TbContentCategory tbContentCategory) {
        return "contentcategoryForm";
    }

    /**
     * 保存
     * @param tbContentCategory
     * @param redirectAttributes
     * @param model
     * @return
     */
    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, RedirectAttributes redirectAttributes, Model model) {
        BaseResult baseResult = service.save(tbContentCategory);

        //用户信息唯一性验证正确，跳转至用户信息展示界面，并提示保存成功
        if (baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/category/list";
        }
        //用户信息验证失败，则提示操作失败，并回到新增或者修改用户信息的界面
        else {
            model.addAttribute("baseResult",baseResult);
            return "contentcategoryForm";
        }
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        //如果id不为空则执行删除
        if (StringUtils.isNoneBlank(ids)){
            service.delete(Long.parseLong(ids));
            baseResult = BaseResult.success("删除分类及其子类及其全部内容成功！");
        }
        //否则删除失败
        else {
            baseResult = BaseResult.fail("抱歉，删除分类失败！");
        }
        return baseResult;
    }

    /**
     * 树形结构
     * @param id
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "tree/data",method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id) {
        if (id == null ){
            id = 0L;
        }
        return service.selectByParentId(id);
    }

}
