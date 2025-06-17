package com.item.study.mapper;

import com.item.study.model.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface CategoryMapper {

    List<CategoryEntity> onQuery(@Param("status") Integer status, @Param("key") String key);

    void onInsert(@Param("body") CategoryEntity body);

    int onUpdate(@Param("body") CategoryEntity body);

    int onDelete(@Param("id") int id);

    void changeStatus(@Param("id") Integer id, @Param("status") Integer status);

}
