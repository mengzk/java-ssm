package com.item.study.service;

import com.item.study.mapper.GoodsMapper;
import com.item.study.model.body.GoodsBody;
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
public class GoodsService {
    @Autowired
    private GoodsMapper mapper;

    //
    public int create(GoodsBody body) throws AppException {
        if(body == null || body.name == null || body.name.isEmpty()) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }

        return 0;
    }

    //
    public int detail(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }

    //
    public ResultList<String> search(int size, int page) throws AppException {
        int start = (page - 1) * size;
        List<String> list = new ArrayList<>();
        return ResultList.create(list, 0, page, size);
    }

    public int count() throws AppException {
        return 0;
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
