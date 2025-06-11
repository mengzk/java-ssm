package com.item.study.model.entity;

import java.util.Date;

/**
 * Author: Meng
 * Date: 2023-03-24
 * Desc:
 */
public class AccountEntity {
    public Integer id;
    public String uid;
    public String pwd;
    public String signature;
    public String phone;
    public String email;
    public String nickname;
    public String icon;
    public String birthday; // 2000-01-01
    public Date createTime;
    public Integer sex; // 1 男 2 女
    public Integer channel; // 0 未知 1 微信 2 QQ 3 微博
    public Integer level; // 0 普通用户 9 管理员
    public Integer score; // 积分
    public Integer status; // 0 正常 1 禁用

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", signature='" + signature + '\'' +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", icon='" + icon + '\'' +
                ", level=" + level +
                ", score=" + score +
                ", status=" + status +
                '}';
    }

}
