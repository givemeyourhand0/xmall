package com.xmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 72703 on 2017/8/6.
 */
public interface IFileService {
    String upload(MultipartFile file,String path);
}
