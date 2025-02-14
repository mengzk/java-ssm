package com.mon.aichat.mapper;

import com.mon.aichat.model.body.ApprovalBody;
import com.mon.aichat.model.dto.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */

public interface ApprovalMapper {

    /**
     * 添加
     */
     int onInsert(@Param("body") ApprovalBody body);

    /**
     * 查询
     */
     List<Device> onQuery(@Param("start") int start, @Param("size") int size);


     int onCount();

     int onHandle(@Param("gid") int gid);

    /**
     * 更新
     */
    int onUpdate(@Param("body") ApprovalBody body);

    /**
     * 删除
     */
     int onDelete(@Param("id") Integer id);

}
