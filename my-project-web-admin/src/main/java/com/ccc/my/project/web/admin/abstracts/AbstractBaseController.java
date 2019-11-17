package com.ccc.my.project.web.admin.abstracts;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.commons.dto.PageInfo;
import com.ccc.my.project.commons.persistence.BaseEntity;
import com.ccc.my.project.commons.persistence.BaseService;
import com.ccc.my.project.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ccc
 * @create 2019-11-10-11:31
 */
public abstract class AbstractBaseController<T extends BaseEntity,S extends BaseService<T>> {
    //注入业务逻辑层
    @Autowired
    protected S service;

    /**
     * 页面跳转
     * @return
     */
    public abstract String list();

    /**
     * 跳转到表单页面
     * @return
     */
    public abstract String form();

    /**
     * 保存信息
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
     * 分页查询
     * @param request
     * @param entity
     * @return
     */
    /*
     *伪分页查询处理的数据条数最好不要超过50000条，mysql一个表存放的数据最好不要超过1000w条
     * 该分页为真分页！！！
     * DataTable用户信息分页查询
     * ajax请求，所以需要返回json数据集，@ResponseBody
     * 由于DataTable在分页的时候ajax会自动向后台发送请求参数，所以接收数据就用request，所有请求数据都在request里面
     * */
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<T> page(HttpServletRequest request,T entity){

        Map<String,Object> result = new HashMap<>();

        //str代表string类型的参数
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");//从第几条数据开始
        String strLength = request.getParameter("length");//每页需要展示多少条信息

        //如果为空则为0 否则就强转为int类型
        int draw = strDraw == null ? 0 :Integer.parseInt(strDraw);
        int start = strStart == null ? 0 :Integer.parseInt(strStart);
        //为空返回10
        int length = strLength == null ? 10 :Integer.parseInt(strLength);

        PageInfo<T> pageInfo = service.page(start, length, draw,entity);

        return pageInfo;

    }

    /**
     * 跳转详情页面
     * @param entity
     * @return
     */
    public abstract String detail(T entity);
}
