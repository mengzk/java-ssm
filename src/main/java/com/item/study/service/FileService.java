package com.item.study.service;

import com.item.study.modules.exception.AppException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 模型服务
 */
@Service
public class FileService {


    /**
     * 上传文件
     */
    public int upload(MultipartFile file, String tag) throws AppException {
        System.out.println("upload file " + tag);
        System.out.println("file name: " + file.getOriginalFilename());
        System.out.println("file size: " + file.getSize());
        return 0;
    }

    /**
     * 上传文件
     */
    public int uploads(List<MultipartFile> files, String tag) throws AppException {
        System.out.println("upload files " + tag);
        for (MultipartFile file : files) {
            System.out.println("file name: " + file.getOriginalFilename());
            System.out.println("file size: " + file.getSize());
        }
        return 0;
    }

    /**
     * 上传文件
     */
    public int uploadMap(List<MultipartFile> files, String tag, String userId) throws AppException {
        System.out.println("upload files " + tag  + " - " + userId);
        for (MultipartFile file : files) {
            System.out.println("file name: " + file.getOriginalFilename());
            System.out.println("file size: " + file.getSize());
        }
        return 0;
    }

}
