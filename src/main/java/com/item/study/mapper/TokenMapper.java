package com.item.study.mapper;

import com.item.study.model.entity.TokenEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 修改Token
 *
 */
public interface TokenMapper {

    int exists(@Param("id") int uid);

    TokenEntity query(@Param("id") int userId);

    int insert(@Param("id") int uid, @Param("value") String token);

    int update(@Param("id") int uid, @Param("value") String token);
    int resets();

    int delete(@Param("id") int userId);

}
