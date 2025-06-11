package com.item.study.mapper;

import com.item.study.model.entity.TokenEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface TmpMapper {

    TokenEntity onQuery(@Param("id") int userId);

    int onCount();

    int onInsert(@Param("id") int uid, @Param("value") String token);

    int onUpdate(@Param("id") int uid, @Param("value") String token);

    int onDelete(@Param("id") int userId);

}
