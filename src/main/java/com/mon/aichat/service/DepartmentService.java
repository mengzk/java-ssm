package com.mon.aichat.service;

import com.mon.aichat.mapper.DepartmentMapper;
import com.mon.aichat.model.body.DepartmentBody;
import com.mon.aichat.model.body.EmployeeBody;
import com.mon.aichat.model.entity.DepartmentEntity;
import com.mon.aichat.modules.exception.AppException;
import com.mon.aichat.modules.exception.CommonError;
import com.mon.aichat.modules.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 部门服务
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper mapper;

    //
    public int add(DepartmentBody body) throws AppException {
        return mapper.onInsert(body);
    }

    //
    public List<DepartmentEntity> query(Integer cId) throws AppException {
        return mapper.onQuery(cId);
    }

    //
    public int count(Integer cId) throws AppException {
        return mapper.onCount(cId);
    }

    //
    public int delete(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return mapper.onDelete(id);
    }

    //
    public int update(DepartmentBody body) throws AppException {
        if(body.id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return mapper.onUpdate(body);
    }


    //
    public int queryStaff(Integer cId, Integer dId) throws AppException {
        return 0;
    }

    //
    public int addStaff(EmployeeBody dId) throws AppException {
        return 0;
    }

    public int removeStaff(EmployeeBody dId) throws AppException {
        return 0;
    }

    public int moveStaff(EmployeeBody body) throws AppException {
        return 0;
    }
}
