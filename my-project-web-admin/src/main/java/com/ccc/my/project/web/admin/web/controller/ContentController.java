package com.ccc.my.project.web.admin.web.controller;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.dto.PageInfo;
import com.ccc.my.project.domain.TbContent;
import com.ccc.my.project.domain.TbUser;
import com.ccc.my.project.web.admin.abstracts.AbstractBaseController;
import com.ccc.my.project.web.admin.service.TbContentService;
import com.ccc.my.project.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ccc
 * @create 2019-11-03 15:41
 */
@Controller
@RequestMapping(value = "content")
public class ContentController extends AbstractBaseController<TbContent, TbContentService> {


    /**
     * @ModelAttribute
     * @param id
     * @return
     */
    @ModelAttribute
    public TbContent getTbContent(Long id) {
        TbContent tbContent = null;
        if (id != null) {
            tbContent = service.getById(id);
        }

        else {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    /**
     * 跳转内容页面
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "contentInfo";
    }

    /*
     * 跳转到用户表单页面
     * */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "contentForm";
    }

    /**
     * 新增/添加
     * @param tbContent
     * @param redirectAttributes
     * @param model
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(TbContent tbContent , RedirectAttributes redirectAttributes, Model model){
        BaseResult baseResult = service.save(tbContent);

        //用户信息唯一性验证正确，跳转至用户信息展示界面，并提示保存成功
        if (baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/content/list";
        }
        //用户信息验证失败，则提示操作失败，并回到新增或者修改用户信息的界面
        else {
            model.addAttribute("baseResult",baseResult);
            return "contentForm";
        }

    }

    /*
     * 删除用户信息
     * */
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("内容信息删除成功！");
        }

        else{
            baseResult = BaseResult.fail("内容信息删除失败！");
        }
        return baseResult;
    }

    /**
     * 用户详情
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbContent tbContent) {
        return "content_detail";
    }


}
