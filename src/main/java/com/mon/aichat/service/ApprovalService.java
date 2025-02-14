package com.mon.aichat.service;

import com.mon.aichat.mapper.ApprovalMapper;
import com.mon.aichat.model.body.ApprovalBody;
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
 */
@Service
public class ApprovalService {
    @Autowired
    ApprovalMapper mapper;

    // 添加
    public int add(ApprovalBody body) throws AppException {
        System.out.println("添加设备: " + body.toString());
        return 0;
    }

    // 查询
    public ResultList<Device> query(int size, int page) throws AppException {
        System.out.println("查询设备: ");
        int start = (page - 1) * size;
        return ResultList.create(mapper.onQuery(start, size), mapper.onCount(), page, size);
    }

    // 删除
    public int delete(Integer id) throws AppException {
        System.out.println("删除设备: " + id);
        if(id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        mapper.onDelete(id);
        return 0;
    }

    // 更新
    public int update(ApprovalBody body) throws AppException {
        System.out.println("更新设备: " + body.toString());
        if(body.id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        mapper.onUpdate(body);
        return 0;
    }

    // 处理
    public int handle(Integer id, Integer status) throws AppException {
        System.out.println("处理设备: " + id + " " + status);
        if(id == null) {
            throw CustomException.create(10011, "设备ID不能为空");
        }
        if(status == null) {
            throw CustomException.create(10011, "设备状态不能为空");
        }
        return 0;
    }
}
