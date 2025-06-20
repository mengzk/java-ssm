package com.item.study.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface GoodsSpecValMapper {

    List<String> onQuery(@Param("id") int id);

    int onInsert(@Param("body") Object body);

    int onUpdate(@Param("body") Object body);

    int onDelete(@Param("id") int userId);
}
