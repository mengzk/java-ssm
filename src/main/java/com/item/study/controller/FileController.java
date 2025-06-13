package com.item.study.controller;

import com.item.study.model.result.ResultBody;
import com.item.study.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 知识库
 */

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService service;

    // 上传文件构建知识库
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ResultBody upload(@RequestParam("file") MultipartFile file, @RequestParam(value = "userId", required = false) String tag) throws Exception {
        return ResultBody.success(service.upload(file, tag));
    }

    // 上传文件构建知识库
    @RequestMapping(value = "uploads", method = RequestMethod.POST)
    public ResultBody uploads(@RequestParam("files") List<MultipartFile> files, @RequestParam(value = "userId", required = false) String tag) throws Exception {
        return ResultBody.success(service.uploads(files, tag));
    }

    // 上传文件构建知识库
    @RequestMapping(value = "uploadMap", method = RequestMethod.POST)
    public ResultBody uploadMap(@RequestParam("files") List<MultipartFile> files, @RequestParam("userId") String userId, @RequestParam("scene") String scene) throws Exception {
        return ResultBody.success(service.uploadMap(files, scene, userId));
    }

}
