package com.item.study.controller;

import com.item.study.model.body.GoodsBody;
import com.item.study.model.result.ResultBody;
import com.item.study.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 * 商品表（spu）：存储商品的通用信息（如名称、描述等）。
 * 规格表（spec）：存储规格名称（如颜色、尺码）。
 * 规格值表（spec_value）：存储具体的规格值（如红色、XL）。
 * SKU表（sku）：每种规格组合为一个SKU，存储价格、库存等。
 * <p>
 * -- 商品SPU表
 * CREATE TABLE goods (
 * id BIGINT PRIMARY KEY AUTO_INCREMENT,
 * name VARCHAR(128) NOT NULL,
 * cover VARCHAR(255),
 * description TEXT,
 * category_id BIGINT,
 * status TINYINT NOT NULL DEFAULT 1,
 * created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
 * updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 * );
 * <p>
 * -- 规格表
 * CREATE TABLE spec (
 * id BIGINT PRIMARY KEY AUTO_INCREMENT,
 * name VARCHAR(64) NOT NULL
 * );
 * <p>
 * -- 规格值表
 * CREATE TABLE spec_value (
 * id BIGINT PRIMARY KEY AUTO_INCREMENT,
 * spec_id BIGINT NOT NULL,
 * value VARCHAR(64) NOT NULL,
 * FOREIGN KEY (spec_id) REFERENCES spec(id)
 * );
 * <p>
 * -- SKU表
 * CREATE TABLE sku (
 * id BIGINT PRIMARY KEY AUTO_INCREMENT,
 * goods_id BIGINT NOT NULL,
 * price INT NOT NULL,
 * cover VARCHAR(255),
 * sold INT NOT NULL DEFAULT 0,
 * stock INT NOT NULL DEFAULT 0,
 * status TINYINT NOT NULL DEFAULT 1,
 * spec_value_ids VARCHAR(128) NOT NULL, -- 逗号分隔的规格值ID
 * created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
 * updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 * FOREIGN KEY (goods_id) REFERENCES goods(id)
 * );
 * -- 商品评论表
 * CREATE TABLE goods_comment (
 * id BIGINT PRIMARY KEY AUTO_INCREMENT,
 * goods_id BIGINT NOT NULL,
 * user_id BIGINT NOT NULL,
 * score TINYINT NOT NULL, -- 评分（如1-5分）
 * content TEXT,           -- 评论内容
 * imgs VARCHAR(1024),      -- 图片（逗号分隔的图片URL）
 * status TINYINT NOT NULL DEFAULT 1, -- 状态（如1-正常，0-删除）
 * created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
 * FOREIGN KEY (goods_id) REFERENCES goods(id)
 * );
 */

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService service;

    /**
     * 新建商品
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() GoodsBody body, @RequestHeader("token") String token) throws Exception {
//        body.uid = TokenUtils.getUserId(token);
        return ResultBody.success(service.create(body));
    }

    /**
     * 商品详情
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public ResultBody detail(@RequestParam("id") Integer id) throws Exception {
        // 假设查询商品详情的逻辑
        return ResultBody.success(service.detail(id));
    }

    /**
     * 查询商品
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody query(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                             @RequestParam(required = false) String keyword,
                             @RequestParam(required = false) Long categoryId,
                             @RequestParam(required = false) Double minPrice,
                             @RequestParam(required = false) Double maxPrice) throws Exception {
        return ResultBody.success(service.search(page, size, keyword));
    }

    /**
     * 查询数量
     */
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public ResultBody count(@RequestParam(value = "tag", defaultValue = "0", required = false) Integer tag,
                            @RequestParam(value = "status", defaultValue = "0", required = false) Integer status) throws Exception {
        return ResultBody.success(service.count());
    }

    /**
     * 更新
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() GoodsBody body) throws Exception {
        return ResultBody.success(service.update(body));
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.delete(id));
    }

    /**
     * 新建商品SKU
     */
    @RequestMapping(value = "addSku", method = RequestMethod.POST)
    public ResultBody addSku(@RequestBody() GoodsBody body, @RequestHeader("token") String token) throws Exception {
//        body.uid = TokenUtils.getUserId(token);
        return ResultBody.success(service.create(body));
    }

    /**
     * 删除商品SKU
     */
    @RequestMapping(value = "deleteSku", method = RequestMethod.DELETE)
    public ResultBody deleteSku(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.deleteSku(id));
    }

    /**
     * 更新商品SKU
     */
    @RequestMapping(value = "updateSku", method = RequestMethod.PUT)
    public ResultBody updateSku(@RequestBody() GoodsBody body) throws Exception {
        return ResultBody.success(service.updateSku(body));
    }

    /**
     * 查询商品SKU
     */
    @RequestMapping(value = "querySku", method = RequestMethod.GET)
    public ResultBody querySku(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.querySku(id));
    }

    /**
     * 添加商品规格
     */
    @RequestMapping(value = "addSpec", method = RequestMethod.POST)
    public ResultBody addSpec(@RequestParam("id") Integer id, @RequestBody() String specs) throws Exception {
        return ResultBody.success(service.addSpec(id, null));
    }

    /**
     * 删除商品规格
     */
    @RequestMapping(value = "deleteSpec", method = RequestMethod.DELETE)
    public ResultBody deleteSpec(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.deleteSpec(id));
    }

    /**
     * 更新商品规格
     */
    @RequestMapping(value = "updateSpec", method = RequestMethod.PUT)
    public ResultBody updateSpec(@RequestBody() String body) throws Exception {
        return ResultBody.success(service.updateSpec(0, body));
    }

    /**
     * 查询商品规格
     */
    @RequestMapping(value = "querySpec", method = RequestMethod.GET)
    public ResultBody querySpec(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.querySpec(id));
    }

    /**
     * 查询商品规格值
     */

    @RequestMapping(value = "querySpecValue", method = RequestMethod.GET)
    public ResultBody querySpecValue(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.querySpecValue(id));
    }

    /**
     * 添加商品规格值
     */
    @RequestMapping(value = "addSpecValue", method = RequestMethod.POST)
    public ResultBody addSpecValue(@RequestParam("id") Integer id, @RequestBody() String value) throws Exception {
        return ResultBody.success(service.addSpecValue(id, null));
    }

    /**
     * 删除商品规格值
     */
    @RequestMapping(value = "deleteSpecValue", method = RequestMethod.DELETE)
    public ResultBody deleteSpecValue(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(service.deleteSpecValue(id));
    }

    /**
     * 更新商品规格值
     */
    @RequestMapping(value = "updateSpecValue", method = RequestMethod.PUT)
    public ResultBody updateSpecValue(@RequestBody() String body) throws Exception {
        return ResultBody.success(service.updateSpecValue(0, body));
    }

}
