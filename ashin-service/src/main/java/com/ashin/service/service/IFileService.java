package com.ashin.service.service;


import com.ashin.service.request.FileUploadRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by Administrator on 2019/10/27.
 */
public interface IFileService {

    String uploadFileV1(MultipartHttpServletRequest request) throws Exception;

    String uploadFileV2(MultipartFile file, FileUploadRequest request) throws Exception;

}
