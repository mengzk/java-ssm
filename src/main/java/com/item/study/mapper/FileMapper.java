package com.item.study.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 文件
 *      1. 保存文件信息，如果有重复文件则不在上传
 *      判断文件是否存在，如果存在则返回文件路径，否则保存文件信息
 */
public interface FileMapper {

    String onQuery(@Param("md5") int md5);

    int onInsert(@Param("fileMD5") int md5);

    int onUpdate(@Param("id") int id);

    int onDelete(@Param("id") int id);
}
