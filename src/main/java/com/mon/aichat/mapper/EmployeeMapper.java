package com.mon.aichat.mapper;

import com.mon.aichat.model.body.EmployeeBody;
import com.mon.aichat.model.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface EmployeeMapper {

    List<EmployeeEntity> onQuery(@Param("cId") Integer cId, @Param("dId") Integer dId);

    int onInsert(@Param("users") List<EmployeeBody.ItemUser> list,
                 @Param("memo") String memo,
                 @Param("auth") String auth,
                 @Param("cId") int cId,
                 @Param("dId") int dId);

    int onDelete(@Param("list") List<Integer> list, @Param("dId") Integer dId);

    int onMove(@Param("list") List<Integer> list, @Param("dId") Integer dId);
}
