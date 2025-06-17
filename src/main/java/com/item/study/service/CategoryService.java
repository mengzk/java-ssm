package com.item.study.service;

import com.item.study.mapper.CategoryMapper;
import com.item.study.model.entity.CategoryEntity;
import com.item.study.model.result.ResultList;
import com.item.study.modules.exception.AppException;
import com.item.study.modules.exception.CommonError;
import com.item.study.modules.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 服务
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper mapper;

    public void addCategory(CategoryEntity body) throws AppException {
        if (body == null || body.name == null || body.name.isEmpty()) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }

        mapper.onInsert(body);
    }

    public void updateCategory(CategoryEntity body) throws AppException {
        if (body == null || body.id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }

        int result = mapper.onUpdate(body);
    }

    public void changeStatus(Integer id, Integer status) throws AppException {
        if(id == null || status == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        mapper.changeStatus(id, status);
    }

    public void deleteCategory(Integer id) throws AppException {
        if (id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }

        int result = mapper.onDelete(id);
    }

    public List<CategoryEntity> onQuery(Integer status, String key) throws AppException {
        return mapper.onQuery(status, key);
    }
}
