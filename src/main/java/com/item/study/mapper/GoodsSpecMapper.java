package com.item.study.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface GoodsSpecMapper {

    List<String> onQuery(@Param("goodsId") int id);

    int onInsert(@Param("name") String name, @Param("goodsId") int goodsId);

    int onUpdate(@Param("id") Integer id, @Param("name") String name);

    int onDelete(@Param("id") int id);
}
