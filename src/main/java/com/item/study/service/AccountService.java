package com.item.study.service;

import com.item.study.mapper.AccountMapper;
import com.item.study.mapper.TokenMapper;
import com.item.study.model.body.AccountBody;
import com.item.study.model.body.LoginBody;
import com.item.study.model.entity.AccountEntity;
import com.item.study.modules.exception.AppException;
import com.item.study.modules.exception.CommonError;
import com.item.study.modules.exception.CustomException;
import com.item.study.utils.TextUtils;
import com.item.study.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 对话服务
 */
@Service
public class AccountService {
    @Autowired
    AccountMapper mapper;
    @Autowired
    TokenMapper tokenMapper;

    public Map<String, Object> login(LoginBody body) throws AppException {
        // 参数校验
        if (TextUtils.isEmpty(body.pwd) || TextUtils.isEmpty(body.phone)) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        // 查询账号
        AccountEntity account = mapper.queryByPhone(body.phone);
        if (account == null) {
            throw CustomException.create(CommonError.ACCOUNT_PWD_ERR);
        }
        // 校验账号密码
        if (!account.pwd.equals(body.pwd)) {
            throw CustomException.create(CommonError.ACCOUNT_PWD_ERR);
        }
        return accountLogin(account, body.phone);
    }

    public Map<String, Object> register(AccountBody body) throws AppException {
        // 参数校验
        if (TextUtils.isEmpty(body.pwd)) {
            throw CustomException.create(CommonError.PARAM_EMPTY);
        }
        // 查询账号
        AccountEntity account = mapper.queryByPhone(body.phone);
        if (account != null) {
            throw CustomException.create(CommonError.ACCOUNT_EXIST);
        }
        // 生成账号
        int count = mapper.lastId();
        body.uid = "U" + String.format("%06d", count + 1001);

        // 注册账号
        int result = mapper.register(body);
        if (result == 0) {
            throw CustomException.create(CommonError.ACCOUNT_REGISTER_ERR);
        }
        return accountLogin(null, body.phone);
    }

    // 获取账号信息
    private Map<String, Object> accountLogin(AccountEntity account, String phone) {
        if (account == null) {
            account = mapper.queryByPhone(phone);
        }
        account.pwd = null; // 隐藏密码
        // 生成token
        String token = TokenUtils.create(account.id, account.level);
        int exists = tokenMapper.exists(account.id);
        if (exists < 1) {
            tokenMapper.insert(account.id, token);
        } else {
            tokenMapper.update(account.id, token);
        }
        // 返回账号信息
        Map<String, Object> map = new HashMap<>();
        map.put("user", account);
        map.put("token", token);
        return map;
    }

    public int query(int size, int page) {
        return 0;
    }

    public int queryById(int id) {
        return 0;
    }

    public int queryByAccount(String account) {
        return 0;
    }

    public int update(AccountBody body) {
        return 0;
    }

    public int delete(Integer id) {
        return 0;
    }

    public int logout(int id) {
        return 0;
    }

    public int reset(String token) {
        return 0;
    }

    public int total() {
        return 0;
    }

    public int info(String code) {
        return 0;
    }

    public int find(String code) {
        return 0;
    }

    public int forget(String code) {
        return 0;
    }

}
