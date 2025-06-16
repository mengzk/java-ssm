package com.item.study.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface GoodsMapper {

    List<String> onQuery(@Param("id") int id);

    String onDetail(@Param("id") int userId);

    int onInsert(@Param("body") Object body);

    int onUpdate(@Param("body") Object body);

    int onDelete(@Param("id") int userId);

    int onCount();
}
