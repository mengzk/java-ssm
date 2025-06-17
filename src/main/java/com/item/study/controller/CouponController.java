package com.item.study.controller;

import com.item.study.model.result.ResultBody;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 优惠券管理控制器
 * 优惠券表（coupon） 用于存储优惠券的基本信息
 * id：主键，自增
 * code：优惠券码（唯一，可选）
 * name：优惠券名称
 * type：类型（如满减、折扣、现金券等）
 * amount：面额/折扣（单位分，整型）
 * min_amount：使用门槛（满多少可用）
 * start_time、end_time：有效期
 * status：状态（如未开始、可用、已用、已过期等）
 * total：发放总量
 * received：已领取数量
 * user_limit：每人限领数量
 * created_at、`updated_at``：创建/更新时间
 * CREATE TABLE coupon (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     code VARCHAR(64) UNIQUE,
     name VARCHAR(128) NOT NULL,
     tag TINYINT NOT NULL DEFAULT 0, -- 0:满减 1:折扣 2:现金券
     amount INT NOT NULL,
     min_amount INT NOT NULL DEFAULT 0,
     start_time DATETIME NOT NULL,
     end_time DATETIME NOT NULL,
     status TINYINT NOT NULL DEFAULT 0, -- 0:未开始 1:可用 2:已用 3:已过期
     total INT NOT NULL DEFAULT 0,
     received INT NOT NULL DEFAULT 0,
     user_limit INT NOT NULL DEFAULT 1,
     created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
     updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 );
 用户优惠券关联表用于记录每个用户领取和使用优惠券的情况
 CREATE TABLE user_coupon (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     user_id BIGINT NOT NULL,           -- 用户ID
     coupon_id BIGINT NOT NULL,         -- 优惠券ID
     status TINYINT NOT NULL DEFAULT 0, -- 0:未使用 1:已使用 2:已过期
     received_at DATETIME DEFAULT CURRENT_TIMESTAMP, -- 领取时间
     used_at DATETIME DEFAULT NULL,     -- 使用时间
     order_id BIGINT DEFAULT NULL,      -- 使用时关联的订单ID
     UNIQUE KEY uk_user_coupon (user_id, coupon_id), -- 每个用户同一优惠券唯一
     FOREIGN KEY (coupon_id) REFERENCES coupon(id)
 );
 */

@RestController
@RequestMapping("/coupon")
public class CouponController {

    /**
     * 添加预约
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() String body, @RequestHeader("token") String token) throws Exception {
//        body.uid = TokenUtils.getUserId(token);
        return ResultBody.success(0);
    }

    /**
     * 查询预约
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultBody queryList(@RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "tag", defaultValue = "0", required = false) Integer tag,
                                @RequestParam(value = "status", defaultValue = "0", required = false) Integer status) throws Exception {
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
