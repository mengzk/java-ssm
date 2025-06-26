package com.item.study.mapper;

import com.item.study.model.body.GoodsBody;
import com.item.study.model.entity.GoodsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface GoodsMapper {

    List<GoodsEntity> onQuery(@Param("keyword") String key,
                              @Param("status") Integer status,
                              @Param("category") Integer category,
                              @Param("start") int start,
                              @Param("size") int size);

    String onDetail(@Param("id") int id);

    int onInsert(@Param("body") GoodsBody body);

    int onUpdate(@Param("body") GoodsBody body);

    int onDelete(@Param("id") int id);

    int onCount(@Param("status") Integer status);
}
