package com.ccc.my.project.web.api.web.controller.v1;

import com.ccc.my.project.commons.dto.BaseResult;
import com.ccc.my.project.domain.TbContent;
import com.ccc.my.project.domain.TbContentCategory;
import com.ccc.my.project.web.api.service.TbContentService;
import com.ccc.my.project.web.api.web.dto.TbContentDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ccc
 * @create 2019-11-13-21:14
 */
@RestController
@RequestMapping(value = "${api.path.v1}/contents")
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent = null;
        if (id == null){
            tbContent = new TbContent();
        }
        return tbContent;
    }

    /**
     * 根据类别ID 查询内容列表
     * @return
     */
    @RequestMapping(value = "ppt",method = RequestMethod.GET)
    //@PathVariable 路径参数
    /*public BaseResult findContentByCategoryId(@PathVariable(value = "category_id") Long categoryId) {*/
        public BaseResult PPT() {
        List<TbContentDTO> tbContentDTOS = null;
        List<TbContent> tbContents = tbContentService.selectByCategoryId(89L);

        if (tbContents != null && tbContents.size() >0) {
            tbContentDTOS = new ArrayList<>();
            for (TbContent tbContent : tbContents) {
                TbContentDTO dto = new TbContentDTO();
                //BeanUtils Spring提供的反射工具类
                //copyProperties(tbContent,dto); 拷贝源数据到目标数据
                BeanUtils.copyProperties(tbContent,dto);
                tbContentDTOS.add(dto);
            }

        }
        return BaseResult.success("成功！",tbContentDTOS);
    }
}
