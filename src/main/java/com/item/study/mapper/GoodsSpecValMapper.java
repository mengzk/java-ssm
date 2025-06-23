package com.item.study.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface GoodsSpecValMapper {

    List<String> onQuery(@Param("specId") int id);

    int onInsert(@Param("value") String value, @Param("specId") int specId);

    int onUpdate(@Param("id") Integer id, @Param("value") String value);

    int onDelete(@Param("id") int id);
}
