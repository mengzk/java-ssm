package com.item.study.service;

import com.item.study.model.result.ResultList;
import com.item.study.modules.exception.AppException;
import com.item.study.modules.exception.CommonError;
import com.item.study.modules.exception.CustomException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 服务
 */
@Service
public class ProductService {

    //
    public int add(String body) throws AppException {
        return 0;
    }

    //
    public ResultList<String> query(int size, int page) throws AppException {
        int start = (page - 1) * size;
        List<String> list = new ArrayList<>();
        return ResultList.create(list, 0, page, size);
    }

    //
    public int delete(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }

    //
    public int update(String body) throws AppException {
//        if(body.id == null) {
//            throw CustomException.create(CommonError.PARAM_EMPTY);
//        }
        return 0;
    }
}
