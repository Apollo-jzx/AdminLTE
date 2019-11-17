package com.ccc.my.project.web.admin.web.controller;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.dto.PageInfo;
import com.ccc.my.project.domain.TbUser;
import com.ccc.my.project.web.admin.abstracts.AbstractBaseController;
import com.ccc.my.project.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ccc
 * @create 2019-10-27 0:44
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends AbstractBaseController<TbUser,TbUserService> {

    /**
     * @ModelAttribute 会在优先执行，所以任何页面的处理 都会携带tbUser
     * @param id
     * @return
     */
    @ModelAttribute
    public TbUser getTbUser(Long id) {
        TbUser tbUser = null;
        if (id != null) {
            tbUser = service.getById(id);
        }

        else {
            tbUser = new TbUser();
        }
        return tbUser;
    }

    /**
     * 用户信息展示（前期做的）
     * 因为后期在做分页的时候 DataTables的异步ajax请求自动向后端请求用户信息数据分页
     * 所有在此只需要跳转到用户信息页面，不需要做查询所有数据操作
     * @return
     */
    @Override
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(/*Model model*/){
        /*List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers",tbUsers);*/
        return "userInfo";
    }

    /*
    * 跳转到用户表单页面
    * */
    @Override
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "userForm";
    }

    /*
    * 在新增用户信息的时候需要验证用户信息的唯一性，如果在数据库中存在相同的用户信息则不能完成新增，因为需要保证
    * 用户信息的唯一性。
    * 在修改用户信息的时候也需要验证用户信息，再提交表单之后，与数据库中的信息对比验证，如果已经存在相同的用户信
    * 息，则不能完成用户信息修改，因为修改之后就违反用户信息的唯一性。
    * */
    @Override
    @RequestMapping(value = "save",method = RequestMethod.POST)
    /*
    *重定向跳转提示信息用 RedirectAttributes，不同于session的长时间存储，
    * RedirectAttributes是每次跳转都要提醒，而且提醒之后就消失。
    *  */
    public String save(TbUser tbUser , RedirectAttributes redirectAttributes,Model model){
        /*model是往request中放 redirectAttributes是往session
        中放携带提示信息重定向用redirectAttributes*/
        BaseResult baseResult = service.save(tbUser);

        //用户信息唯一性验证正确，跳转至用户信息展示界面，并提示保存成功
        if (baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }
        //用户信息验证失败，则提示操作失败，并回到新增或者修改用户信息的界面
        else {
            model.addAttribute("baseResult",baseResult);
            return "userForm";
        }

    }

    /*
    * 删除用户信息
    * */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("用户数据删除成功！");
        }

        else{
            baseResult = BaseResult.fail("用户数据删除失败！");
        }
        return baseResult;
    }

    /**
     * 用户详情
     * @param tbUser
     * @return
     */
    @Override
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbUser tbUser) {
        return "user_detail";
    }

}

