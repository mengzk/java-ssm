package com.item.study.controller;

import com.item.study.model.result.ResultBody;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 * 商品表（spu）：存储商品的通用信息（如名称、描述等）。
 * 规格表（spec）：存储规格名称（如颜色、尺码）。
 * 规格值表（spec_value）：存储具体的规格值（如红色、XL）。
 * SKU表（sku）：每种规格组合为一个SKU，存储价格、库存等。
 -- 商品SPU表
 CREATE TABLE goods (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(128) NOT NULL,
     description TEXT,
     category_id BIGINT,
     status TINYINT NOT NULL DEFAULT 1,
     cover VARCHAR(255),
     created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
     updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 );

 -- 规格表
 CREATE TABLE spec (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(64) NOT NULL
 );

 -- 规格值表
 CREATE TABLE spec_value (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     spec_id BIGINT NOT NULL,
     value VARCHAR(64) NOT NULL,
     FOREIGN KEY (spec_id) REFERENCES spec(id)
 );

 -- SKU表
 CREATE TABLE sku (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     goods_id BIGINT NOT NULL,
     price INT NOT NULL,
     stock INT NOT NULL DEFAULT 0,
     status TINYINT NOT NULL DEFAULT 1,
     spec_value_ids VARCHAR(128) NOT NULL, -- 逗号分隔的规格值ID
     created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
     updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     FOREIGN KEY (goods_id) REFERENCES goods(id)
 );
 */

@RestController
@RequestMapping("/goods")
public class GoodsController {

    /**
     * 新建商品
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() String body, @RequestHeader("token") String token) throws Exception {
//        body.uid = TokenUtils.getUserId(token);
        return ResultBody.success(0);
    }

    /**
     * 查询商品详情
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public ResultBody detail(@RequestParam("id") Integer id) throws Exception {
        if (id == null || id <= 0) {
            return ResultBody.fail( 0,"Invalid ID");
        }
        // 假设查询商品详情的逻辑
        return ResultBody.success(0);
    }

    /**
     * 查询商品
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResultBody queryList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) Long categoryId,
                                @RequestParam(required = false) Double minPrice,
                                @RequestParam(required = false) Double maxPrice) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 查询
     */
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public ResultBody count(@RequestParam(value = "tag", defaultValue = "0", required = false) Integer tag,
                            @RequestParam(value = "status", defaultValue = "0", required = false) Integer status) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 更新预约
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() String body) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 删除预约
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(0);
    }
}
