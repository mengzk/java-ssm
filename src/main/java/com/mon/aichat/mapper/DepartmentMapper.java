package com.mon.aichat.mapper;

import com.mon.aichat.model.body.DepartmentBody;
import com.mon.aichat.model.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface DepartmentMapper {

    int onUpdate(@Param("body") DepartmentBody body);

    int onInsert(@Param("body") DepartmentBody body);

    List<DepartmentEntity> onQuery(@Param("cId") int cId);

    int onDelete(@Param("id") int id);

    int onCount(@Param("cId") int cId);
}
