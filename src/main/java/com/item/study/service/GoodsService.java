package com.item.study.service;

import com.item.study.mapper.GoodsMapper;
import com.item.study.mapper.GoodsSpecMapper;
import com.item.study.model.body.GoodsBody;
import com.item.study.model.entity.GoodsSpecValEntity;
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
    @Autowired
    GoodsSpecMapper specMapper;
    @Autowired
    GoodsSpecValEntity specValEntity;

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


    // 添加商品SKU
    public int addSku(Integer goodsId, GoodsBody body) throws AppException {
        if(body == null || body.skus == null || body.skus.isEmpty()) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }

    // 删除商品SKU
    public int deleteSku(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }
    // 更新商品SKU
    public int updateSku(GoodsBody body) throws AppException {
        if(body == null || body.skus == null || body.skus.isEmpty()) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }
    // 查询商品SKU
    public int querySku(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }

    //
    public int addSpec(Integer id, List<String> specs) throws AppException {
        if(id == null || specs == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }
    //
    public int deleteSpec(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }
    //
    public int updateSpec(Integer id, String name) throws AppException {
        if(id == null || name == null || name.isEmpty()) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }
    //
    public int querySpec(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }

    public ResultList<String> querySpecList(Integer goodsId ,int size, int page) throws AppException {
        int start = (page - 1) * size;
        List<String> list = new ArrayList<>();
        return ResultList.create(list, 0, page, size);
    }

   public int querySpecValue(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }

    public int deleteSpecValue(Integer id) throws AppException {
        if(id == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }

    public int updateSpecValue(Integer id, String value) throws AppException {
        if(id == null || value == null || value.isEmpty()) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }

    public int addSpecValue(Integer specId, List<String> specVals) throws AppException {
        if(specId == null || specVals == null) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        return 0;
    }

}
