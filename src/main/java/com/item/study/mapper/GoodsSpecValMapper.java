package com.item.study.mapper;

import com.item.study.model.body.GoodsSpecValBody;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface GoodsSpecValMapper {

    List<GoodsSpecValBody> onQuery(@Param("specId") int id);

    int onInsert(@Param("value") String value, @Param("specId") int specId);

    int onInserts(@Param("list") List<GoodsSpecValBody> list, @Param("specId") int specId);

    int onUpdate(@Param("id") Integer id, @Param("value") String value);

    int onDelete(@Param("id") int id);
}
