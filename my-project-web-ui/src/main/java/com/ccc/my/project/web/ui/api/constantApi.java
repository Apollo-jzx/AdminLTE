package com.ccc.my.project.web.ui.api;

import com.ccc.my.project.commons.utils.HttpClientUtils;
import com.ccc.my.project.commons.utils.MapperUtils;
import com.ccc.my.project.web.ui.api.API;
import com.ccc.my.project.web.ui.dto.TbContent;

import java.util.List;

/**
 * @author ccc
 * @create 2019-12-09-16:19
 */
public class constantApi {
    public static List<TbContent> ppt() {
        List<TbContent> tbContents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENTS_PPT);
        try {
            MapperUtils.json2listByTree(result,"data",TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
}
