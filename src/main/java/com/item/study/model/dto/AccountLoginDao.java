package com.item.study.model.dto;

import com.item.study.model.entity.AccountEntity;

import java.util.Date;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 账号
 */
public class AccountLoginDao extends AccountDao {
    public String token; // 登录令牌

    public AccountLoginDao(AccountEntity entity) {
        super(entity);
    }

}
