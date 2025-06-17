package com.item.study.controller;

import com.item.study.model.result.ResultBody;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 订单管理控制器

 订单表一般包含订单的基本信息、用户、金额、状态、时间等字段。
 - 金额（单位分，整型
 订单表（order） 用于存储订单的基本信息
 CREATE TABLE `order` (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     code VARCHAR(45) NOT NULL UNIQUE,
     user_id BIGINT NOT NULL,
     total_amount INT NOT NULL,
     deduct_amount INT NOT NULL,
     status TINYINT NOT NULL DEFAULT 0,
     pay_type TINYINT DEFAULT NULL,
     address_id BIGINT DEFAULT NULL,
     remark VARCHAR(255) DEFAULT NULL,
     created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
     updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 );
 订单明细表（order_item） 用于存储每个订单的商品明细
 CREATE TABLE order_item (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     order_id BIGINT NOT NULL,
     sku_id BIGINT NOT NULL,
     goods_name VARCHAR(100) NOT NULL,
     sku_spec VARCHAR(100) DEFAULT NULL,
     price INT NOT NULL,
     quantity INT NOT NULL,
     created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (order_id) REFERENCES `order`(id)
 );
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 添加订单
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResultBody create(@RequestBody() String body, @RequestHeader("token") String token) throws Exception {
//        body.uid = TokenUtils.getUserId(token);
        return ResultBody.success(0);
    }

    /**
     * 支付订单
     */
    @RequestMapping(value = "pay", method = RequestMethod.POST)
    public ResultBody pay(@RequestParam("id") Integer id, @RequestHeader("token") String token) throws Exception {
        // 这里可以根据id进行支付操作
        return ResultBody.success(0);
    }

    /**
     * 查询订单详情
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public ResultBody detail(@RequestParam("id") Integer id) throws Exception {
        // 这里可以根据id查询预约详情
        return ResultBody.success(0);
    }

    /**
     * 查询订单
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultBody queryList(@RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "tag", defaultValue = "0", required = false) Integer tag,
                                @RequestParam(value = "status", defaultValue = "0", required = false) Integer status) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 查询订单数量
     */
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public ResultBody count(@RequestParam(value = "tag", defaultValue = "0", required = false) Integer tag,
                            @RequestParam(value = "status", defaultValue = "0", required = false) Integer status) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 更新订单
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() String body) throws Exception {
        return ResultBody.success(0);
    }

    /**
     * 取消订单
     */
    @RequestMapping(value = "cancel", method = RequestMethod.PUT)
    public ResultBody cancel(@RequestParam("id") Integer id) throws Exception {
        // 这里可以根据id取消订单
        return ResultBody.success(0);
    }

    /**
     * 删除订单
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success(0);
    }
}
