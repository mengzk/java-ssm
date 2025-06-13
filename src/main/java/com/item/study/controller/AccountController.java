package com.item.study.controller;

import com.item.study.model.body.AccountBody;
import com.item.study.model.body.LoginBody;
import com.item.study.model.result.ResultBody;
import com.item.study.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 账号管理
 * 账号表（account） 用于存储用户的基本信息
 * CREATE TABLE account (
     id BIGINT PRIMARY KEY AUTO_INCREMENT,
     username VARCHAR(45) NOT NULL UNIQUE,
     password VARCHAR(24) NOT NULL,
     nickname VARCHAR(45) DEFAULT NULL,
     email VARCHAR(63) DEFAULT NULL,
     phone VARCHAR(11) DEFAULT NULL,
     avatar VARCHAR(200) DEFAULT NULL,
     gender TINYINT DEFAULT 0,
     birthday DATE DEFAULT NULL,
     last_login_time DATETIME DEFAULT NULL,
     last_login_ip VARCHAR(45) DEFAULT NULL,
     address VARCHAR(255) DEFAULT NULL,
     real_name VARCHAR(64) DEFAULT NULL,
     id_card VARCHAR(32) DEFAULT NULL,
     level INT DEFAULT 0,
     score INT DEFAULT 0,
     vip_expire_time DATETIME DEFAULT NULL,
     status TINYINT NOT NULL DEFAULT 1,
     created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
     updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 );
 */

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService service;

    /**
     * 登录账号
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultBody login(@RequestBody() LoginBody body) throws Exception {
        return ResultBody.success(service.login(body));
    }

    /**
     * 注册账号
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ResultBody register(@RequestBody() AccountBody body) throws Exception {
        return ResultBody.success(service.register(body));
    }

    /**
     * 查询账号
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public ResultBody query(@RequestParam("size") int size, @RequestParam("page") int page) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 更新账号
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultBody update(@RequestBody() AccountBody body) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 删除账号
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultBody delete(@RequestParam("id") Integer id) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ResultBody logout(@RequestHeader(value = "token", required = true) String token) throws Exception {
        System.out.println("logout: "+token);
        return ResultBody.success("");
    }

    /**
     * 重置密码
     */
    @RequestMapping(value = "reset", method = RequestMethod.PUT)
    public ResultBody reset(@RequestHeader("token") String token) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 查询账号数量
     */
    @RequestMapping(value = "total", method = RequestMethod.GET)
    public ResultBody total() throws Exception {
        return ResultBody.success("");
    }

    /**
     * 查询账号信息
     */
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public ResultBody info(@RequestHeader(value = "token", required = true) String token) throws Exception {
        return ResultBody.success(service.info(token));
    }

    /**
     * 找回账号/密码
     */
    @RequestMapping(value = "find", method = RequestMethod.POST)
    public ResultBody find(@RequestBody() AccountBody body) throws Exception {
        return ResultBody.success("");
    }

    /**
     * 忘记密码/修改密码
     */
    @RequestMapping(value = "forget", method = RequestMethod.PUT)
    public ResultBody forget(@RequestBody() AccountBody body) throws Exception {
        return ResultBody.success("");
    }
}
