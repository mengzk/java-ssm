package com.mdx.hubing.service.impl;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.exception.ErrorCode;
import com.mdx.hubing.model.body.LoginBody;
import com.mdx.hubing.model.dto.AccountDao;
import com.mdx.hubing.model.dto.WxResult;
import com.mdx.hubing.model.entity.AccountEntity;
import com.mdx.hubing.mapper.AccountMapper;
import com.mdx.hubing.module.api.WxApis;
import com.mdx.hubing.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc: 账号服务
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    /**
     * 注册
     */
    @Override
    public AccountDao register(LoginBody body) throws CustomException {
        Integer id = accountMapper.check(body);
        AccountEntity entity = new AccountEntity(body.phone, body.email, body.pwd);
//        try {
            if(id != null) {
                throw CustomException.create(ErrorCode.ACCOUNT_EXIST);
            }
            id = accountMapper.register(entity);
//        } catch (CustomException e) {
//            System.out.println(e.getMessage());
//        }
        System.out.println("user-id:" + id);
        return null;
    }

    @Override
    public AccountDao login(LoginBody body) throws CustomException {
        if(body.pwd.isEmpty() || (body.phone.isEmpty() && body.email.isEmpty())) {
            throw CustomException.create(ErrorCode.ACCOUNT_EMPTY);
        }
        AccountDao account = accountMapper.login(body);
        if(account == null) {
            throw CustomException.create(ErrorCode.ACCOUNT_ERR);
        }
        return account;
    }

    /**
     * 微信注册
     */
    @Override
    public AccountDao wxLogin(LoginBody body) throws CustomException {
        if (body.sign == null) {
            throw CustomException.create(ErrorCode.PARAM_EMPTY);
        }
        WxResult data = new WxApis().getWxOpenid(body.sign);
        if (data == null || data.openid == null) {
            throw CustomException.create(ErrorCode.WX_ACCOUNT);
        } else {
            body.sign = data.openid;
        }
        // 获取账号
        AccountDao account = null;
        try {
            account = accountMapper.queryByUid(data.openid);
            System.out.println(account);
            // 没有注册账号
            if (account == null) {
                int size = accountMapper.accountNum();
//                System.out.println(body);
                AccountEntity entity = new AccountEntity();
//                BeanUtils.copyProperties(body, entity);
                System.out.println(entity);
//                accountMapper.register(entity);
                account = accountMapper.queryByUid(data.openid);
                System.out.println(account);
            }
        } catch (Exception e) {
            throw CustomException.create(ErrorCode.LOGIN_ERR);
        }
        return account;
    }

    @Override
    public int update(LoginBody body) {
        int code = 0;
        try{
            System.out.println(body);
            code = accountMapper.updateAccount(body);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    @Override
    public int reset(LoginBody body) {
        return 0;
    }

    @Override
    public int logout(String token) {
        return accountMapper.logout(0);
    }

    @Override
    public int delete(String token) {
        return 0;
    }

    @Override
    public int total() {
        return accountMapper.accountNum();
    }

    @Override
    public ArrayList<AccountDao> accountAll() {
        return accountMapper.accountAll();
    }
}
