package com.item.study.controller;

import com.item.study.model.result.ResultBody;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 *
 * -- 促销表
 * CREATE TABLE promotion (
 *     id BIGINT PRIMARY KEY AUTO_INCREMENT,
 *     name VARCHAR(128) NOT NULL COMMENT '促销名称',
 *     type TINYINT NOT NULL COMMENT '促销类型：1-折扣，2-满减，3-赠品',
 *     discount DECIMAL(5, 2) DEFAULT NULL COMMENT '折扣值（如0.8表示8折）',
 *     threshold DECIMAL(10, 2) DEFAULT NULL COMMENT '满减门槛金额',
 *     reduction DECIMAL(10, 2) DEFAULT NULL COMMENT '满减金额',
 *     start_time DATETIME NOT NULL COMMENT '开始时间',
 *     end_time DATETIME NOT NULL COMMENT '结束时间',
 *     status TINYINT NOT NULL DEFAULT 1 COMMENT '状态：1-启用，0-禁用',
 *     created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
 *     updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 * );
 *
 * -- 商品促销关联表
 * CREATE TABLE goods_promotion (
 *     id BIGINT PRIMARY KEY AUTO_INCREMENT,
 *     goods_id BIGINT NOT NULL COMMENT '商品ID',
 *     promotion_id BIGINT NOT NULL COMMENT '促销ID',
 *     FOREIGN KEY (goods_id) REFERENCES goods(id),
 *     FOREIGN KEY (promotion_id) REFERENCES promotion(id)
 * );
 */

//@RestController
//@RequestMapping("/tmp")
public class PromotionController {

    /**
     * 新增
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() String body, @RequestHeader("token") String token) throws Exception {
//        body.uid = TokenUtils.getUserId(token);
        return ResultBody.success(0);
    }

    /**
     * 查询详情
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public ResultBody detail(@RequestParam("id") Integer id) throws Exception {
        if (id == null || id <= 0) {
            return ResultBody.fail(0, "Invalid ID");
        }
        // Here you would typically fetch the details from the database
        return ResultBody.success(0);
    }

    /**
     * 查询
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResultBody queryList(@RequestParam("page") Integer page,
                                @RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                                @RequestParam(value = "tag", required = false) Integer tag,
                                @RequestParam(value = "status", required = false) Integer status) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 查询数量
     */
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public ResultBody count(@RequestParam(value = "tag", defaultValue = "0", required = false) Integer tag,
                            @RequestParam(value = "status", defaultValue = "0", required = false) Integer status) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 更新
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() String body) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(0);
    }
}
