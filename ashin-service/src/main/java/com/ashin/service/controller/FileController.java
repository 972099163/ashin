package com.ashin.service.controller;


import com.ashin.api.enums.StatusCode;
import com.ashin.api.response.BaseResponse;
import com.ashin.service.annotation.LogAnnotation;
import com.ashin.service.request.FileUploadRequest;
import com.ashin.service.service.IFileService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

/**
 * 文件上传controller
 * @Author:debug (SteadyJack)
 * @Date: 2019/10/27 11:07
 **/
@RestController
@RequestMapping("file")
public class FileController extends AbstractController{

    @Autowired
    private IFileService fileService;


    /**
     * 为商品上传图片
     * 上传文件-方式1：MultipartHttpServletRequest 接收前端参数
     * @return
     */
    @LogAnnotation("下载导出")
    @RequestMapping(value = "upload/v1",method = RequestMethod.POST)
    public BaseResponse uploadV1(MultipartHttpServletRequest request){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap= Maps.newHashMap();
        try {
            String url=fileService.uploadFileV1(request);

            resMap.put("fileUrl",url);
        }catch (Exception e){
            e.printStackTrace();
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        response.setData(resMap);
        return response;
    }

    /**
     * 上传文件-方式2
     * @return
     */
    @RequestMapping(value = "upload/v2",method = RequestMethod.POST)
    public BaseResponse uploadV2(@RequestParam("appendix") MultipartFile file, FileUploadRequest request){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap= Maps.newHashMap();
        try {
            String url=fileService.uploadFileV2(file,request);

            resMap.put("fileUrl",url);
        }catch (Exception e){
            e.printStackTrace();
            response=new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        response.setData(resMap);
        return response;
    }


    //访问图片时：域名 + 图片所在的磁盘目录-即数据库存储的file_url
}




































