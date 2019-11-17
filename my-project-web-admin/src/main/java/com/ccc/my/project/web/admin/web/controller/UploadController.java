package com.ccc.my.project.web.admin.web.controller;

import com.ccc.my.project.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 文件上传
 * @author ccc
 * @create 2019-11-04 14:18
 */
@Controller
public class UploadController {

    @Autowired
    private TbContentService tbContentService;

    private static final String UPLOAD_PATH = "/static/upload/";

    /**
     * 文件上传
     *
     * @param dropFile    dropZone 上传
     * @param editorFiles wangDditor富文本编辑器上传图片
     * @return
     */
    //异步上传，不会条状页面，消息是以json格式传回前端所以用@ResponseBody
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upLoad(MultipartFile dropFile, MultipartFile[] editorFiles, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        //dropZone图片上传
        if (dropFile != null) {
            result.put("fileName", writeFile(dropFile, request));
        }
        //wangEditor上传
        if (editorFiles != null && editorFiles.length > 0) {
            List<String> fileNames = new ArrayList<>();

            for (MultipartFile editorFile : editorFiles) {
                fileNames.add(writeFile(editorFile, request));
            }

            result.put("errno", 0);
            result.put("data", fileNames);
        }
        return result;
    }

    /**
     * 上传方法
     * @param multipartFile
     * @param request
     * @return
     */

    private String writeFile(MultipartFile multipartFile,HttpServletRequest request) {
        //获取文件的后缀 文件名点（'.'）后面的后缀名
        String fileName = multipartFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        //文件存放的路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);

        //判断文件路径是否存在，不存在则自动创建
        File file = new File(filePath);
        if (!file.exists()){
            file.mkdir();
        }

        //将文件写入目录下
        //随机生成UUID+获取的文件后缀，保证唯一性
        file = new File(filePath,UUID.randomUUID() + fileSuffix);
        //写入
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //返回完整的路径，拼接localhost ：// 8080 ： 业务
        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return serverPath + UPLOAD_PATH + file.getName();
    }

}

