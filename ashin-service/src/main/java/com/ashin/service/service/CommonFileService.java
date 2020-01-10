package com.ashin.service.service;


import com.ashin.model.common.Constant;
import com.ashin.model.entity.Appendix;
import com.ashin.model.mapper.AppendixMapper;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/10/27 11:36
 **/
@Component
public class CommonFileService {

    private static final SimpleDateFormat FORMAT=new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private AppendixMapper appendixMapper;


    /**
     * 上传文件 - nio的方式
     * @param file
     * @throws Exception
     */
    public String upload(MultipartFile file, final Integer moduleId, String module) throws Exception{
        String fileName=file.getOriginalFilename();
        String suffix=StringUtils.substring(fileName,StringUtils.indexOf(fileName,"."));
        Long size=file.getSize();

        //附件输入流
        InputStream is=file.getInputStream();

        //创建新文件存储的磁盘目录前缀、创建磁盘目录
        String filePathPrefix=FORMAT.format(DateTime.now().toDate())+File.separator+module+moduleId;
        String rootPath=filePathPrefix;
        Path path=Paths.get(rootPath);
        if (!Files.exists(path)){
            Files.createDirectories(path);
        }
        //创建新的文件
        String newFileName=System.nanoTime()+suffix;
        String newFile=rootPath+File.separator+newFileName;
        path=Paths.get(newFile);

        //方式一
        //Files.copy(is,path, StandardCopyOption.REPLACE_EXISTING); //如果存在则覆盖
        //方式二
        Files.write(path,file.getBytes());

        Appendix entity=new Appendix(moduleId,moduleId+"",module,newFileName,size.toString(),suffix,newFile);
        appendixMapper.insertSelective(entity);

        return newFile;
    }


    /**
     * 上传文件 - 传统的方式
     * @throws Exception
     */
    public String upload2(MultipartFile multipartFile, final Integer moduleId, String module) throws Exception{
       /* String fileName=multipartFile.getOriginalFilename();
        String suffix=StringUtils.substring(fileName,StringUtils.indexOf(fileName,"."));
        Long size=multipartFile.getSize();

        //附件输入流
        InputStream is=multipartFile.getInputStream();

        //创建新文件存储的磁盘目录前缀、创建磁盘目录
        String filePathPrefix=FORMAT.format(DateTime.now().toDate())+File.separator+module.getCode()+moduleId;
        String rootPath=Constant.FilePrefix2+filePathPrefix;

        //创建新的文件
        String newFileName=System.nanoTime()+suffix;
        String newFile=rootPath+File.separator+newFileName;

        //创建目录
        File file=new File(newFile);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        //直接执行数据流的转换
        multipartFile.transferTo(file);

        Appendix entity=new Appendix(moduleId,module.getCode(),module.getName(),newFileName,size.toString(),suffix,newFile);
        appendixMapper.insertSelective(entity);
*/
       // return newFile;
        return null;
    }
}



































