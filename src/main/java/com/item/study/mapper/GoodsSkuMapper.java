package com.item.study.mapper;

import com.item.study.model.body.GoodsSkuBody;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface GoodsSkuMapper {

    List<GoodsSkuBody> onQuery(@Param("id") int id);

    int onInsert(@Param("body") GoodsSkuBody body);

    int onUpdate(@Param("body") GoodsSkuBody body);

    int onDelete(@Param("id") int userId);
}
