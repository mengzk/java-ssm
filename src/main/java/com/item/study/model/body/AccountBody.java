package com.item.study.model.body;

import java.util.Date;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class AccountBody {
    public String uid;
    public String pwd;
    public String nickname;
    public String email;
    public String phone;
    public String signature;
    public String icon;
    public String code;
    public String birthday;
    public Date createTime;
    public int sex; // 1 男 2 女
    public int channel; // 0 未知 1 微信 2 QQ 3 微博
    public int level; // 0 普通用户 9 管理员
    public int score; // 积分
    public int status; // 0 正常 1 禁用

    public AccountBody() {
        createTime = new Date();
    }

    @Override
    public String toString() {
        return "AccountBody{" +
                "uid='" + uid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", signature='" + signature + '\'' +
                ", icon='" + icon + '\'' +
                ", code='" + code + '\'' +
                ", birthday='" + birthday + '\'' +
                ", createTime=" + createTime +
                ", sex=" + sex +
                ", channel=" + channel +
                ", level=" + level +
                ", score=" + score +
                ", status=" + status +
                '}';
    }
}
