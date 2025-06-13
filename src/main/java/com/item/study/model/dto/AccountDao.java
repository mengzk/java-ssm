package com.item.study.model.dto;

import com.item.study.model.entity.AccountEntity;

import java.util.Date;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 账号
 */
public class AccountDao {
    public Integer id;
    public String uid;
    public String phone;
    public String email;
    public String nickname;
    public String profile;
    public String birthday; // 2000-01-01
    public Date createTime;
    public Integer gender; // 1 男 2 女
    public Integer level; // 0 普通用户 9 管理员
    public Integer score; // 积分
    public Integer status; // 0 正常 1 禁用

    public AccountDao(AccountEntity entity) {
        this.id = entity.id;
        this.uid = entity.uid;
        this.phone = entity.phone;
        this.email = entity.email;
        this.nickname = entity.nickname;
        this.profile = entity.profile;
        this.birthday = entity.birthday;
        this.createTime = entity.createTime;
        this.gender = entity.gender;
        this.level = entity.level;
        this.score = entity.score;
        this.status = entity.status;
    }

}
