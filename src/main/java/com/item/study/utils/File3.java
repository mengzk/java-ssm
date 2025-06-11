package com.item.study.utils;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class File3 {

    public static File getFile(MultipartFile multipartFile, String path) throws IOException {
        // 检查MultipartFile是否为空
        if (multipartFile == null || multipartFile.isEmpty()) {
            throw new IOException("文件为空");
        }

        // 创建File对象
        File file = new File(path);

        // 使用try-with-resources语句自动关闭资源
        try (InputStream inputStream = multipartFile.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(file)) {

            // 将输入流中的数据写入到输出流（即文件）中
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }

        // 返回创建的File对象
        return file;
    }

    public static File getFile2(MultipartFile multipartFile, String path) {
        File file = new File(path);
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileCopyUtils.copy(multipartFile.getBytes(), file);
        }catch (Exception e) {
            e.fillInStackTrace();
        }
        return file;
    }

    public static MultipartFile getMultipartFile(File file) throws Exception {
// 创建FileItemFactory实例
        FileItemFactory factory = new DiskFileItemFactory();

        // 创建一个FileItem来包装File对象
        FileItem fileItem = factory.createItem(
                "file", // 表单字段名，可以自定义
                "application/octet-stream", // 内容类型
                true, // 是否使用临时文件存储上传的数据
                file.getName() // 文件名
        );

        // 将File对象的内容写入到FileItem中
        fileItem.write(new File(fileItem.getName()));

        // 使用CommonsMultipartFile来包装FileItem
//        return new DiskFileItem(fileItem).getStoreLocation();
        return null;
    }


    public static void delete(File file) {
        try {
            file.delete();
        }catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    public static void delete(String path) {
        try {
            System.out.println("-----> delete: " + path);
            File file = new File(path);
            file.delete();
        }catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}
