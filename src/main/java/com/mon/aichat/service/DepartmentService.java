package com.mon.aichat.service;

import com.mon.aichat.mapper.DepartmentMapper;
import com.mon.aichat.mapper.EmployeeMapper;
import com.mon.aichat.model.body.DepartmentBody;
import com.mon.aichat.model.body.EmployeeBody;
import com.mon.aichat.model.entity.DepartmentEntity;
import com.mon.aichat.model.entity.EmployeeEntity;
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

    @Autowired
    EmployeeMapper eMapper;

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
    public List<EmployeeEntity> queryStaff(Integer cId, Integer dId) throws AppException {
//        System.out.println("cId: " + cId + ", dId: " + dId);
        return eMapper.onQuery(cId, dId);
    }

    //
    public int addStaff(EmployeeBody body) throws AppException {
        return eMapper.onInsert(body.list, body.memo, body.auth, body.companyId, body.departmentId);
    }

    public int removeStaff(List<Integer> ids, Integer dId) throws AppException {
        return eMapper.onDelete(ids, dId);
    }

    public int moveStaff(List<Integer> ids, Integer dId) throws AppException {
        return eMapper.onMove(ids, dId);
    }
}
