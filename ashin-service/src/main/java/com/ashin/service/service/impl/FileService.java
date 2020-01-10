package com.ashin.service.service.impl;/**
 * Created by Administrator on 2019/10/27.
 */


import com.ashin.model.common.Constant;
import com.ashin.service.request.FileUploadRequest;
import com.ashin.service.service.CommonFileService;
import com.ashin.service.service.IFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 上传文件
 * @Author:debug (SteadyJack)
 * @Date: 2019/10/27 11:08
 **/
@Service
public class FileService implements IFileService {

    private static final Logger log= LoggerFactory.getLogger(FileService.class);



    @Autowired
    private CommonFileService commonFileService;

    //第一种方法
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String uploadFileV1(MultipartHttpServletRequest request) throws Exception {
        MultipartFile multipartFile=request.getFile("appendix");

        String itemName=request.getParameter("itemName");
        String itemCode=request.getParameter("itemCode");
        String itemTotal=request.getParameter("itemTotal");


        return  commonFileService.upload(multipartFile,1, Constant.SysModule);


    }

    //第二种方法
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String uploadFileV2(MultipartFile file, FileUploadRequest request) throws Exception {
   /*     Item item=new Item(request.getItemName(),request.getItemCode(),request.getItemTotal());
        item.setPurchaseTime(DateTime.now().toDate());
        itemMapper.insertSelective(item);

        String url="";
        if (item.getId()>0){
            url=commonFileService.upload2(file,1, Constant.SysModule.ModuleItem);
        }
        return url;*/
    return null;
    }
}



































