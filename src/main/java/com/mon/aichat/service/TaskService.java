package com.mon.aichat.service;

import com.mon.aichat.mapper.ApprovalMapper;
import com.mon.aichat.mapper.RecordTaskMapper;
import com.mon.aichat.mapper.TaskMapper;
import com.mon.aichat.model.body.ApprovalBody;
import com.mon.aichat.model.body.TaskBody;
import com.mon.aichat.model.dto.Device;
import com.mon.aichat.model.result.ResultList;
import com.mon.aichat.modules.exception.AppException;
import com.mon.aichat.modules.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 审批服务
 * 一个任务，包含N条流转记录
 */
@Service
public class TaskService {
    @Autowired
    TaskMapper mapper;
    @Autowired
    ApprovalMapper approvalMapper;
//    @Autowired RecordTaskMapper recordTaskMapper;

    // 添加
    public int create(TaskBody body) throws AppException {
        return 0;
    }

    // 查询
    public ResultList<String> query(Integer statue, int size, int page) throws AppException {
        System.out.println("查询: ");
        int start = (page - 1) * size;
        return ResultList.create(mapper.onQuery(start, size), mapper.onCount(0), page, size);
    }

    // 详情
    public Device detail(Integer id) throws AppException {
        if (id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        return null;
    }

    // 删除
    public int delete(Integer id) throws AppException {
        if (id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        mapper.onDelete(id);
        return 0;
    }

    // 更新
    public int update(TaskBody body) throws AppException {
        if (body.id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        mapper.onUpdate("body");
        return 0;
    }

    // 处理
    public int handle(Integer id, Integer status) throws AppException {
        if (id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        if (status == null) {
            throw CustomException.create(10011, "设备状态不能为空");
        }
        return 0;
    }
}
