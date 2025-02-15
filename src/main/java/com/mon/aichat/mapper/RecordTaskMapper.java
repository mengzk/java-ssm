package com.mon.aichat.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 任务
 */
public interface RecordTaskMapper {

    List<String> onQuery(@Param("start") int start, @Param("size") int size);

    int onCount(@Param("id") int id);

    int onInsert(@Param("uid") int uid, @Param("status") int status);

    int onUpdate(@Param("id") String id);

    int onDelete(@Param("id") int id);
}
