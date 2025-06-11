package com.item.study.mapper;

import com.item.study.model.body.AccountBody;
import com.item.study.model.body.LoginBody;
import com.item.study.model.dto.AccountDao;
import com.item.study.model.entity.AccountEntity;
import org.apache.ibatis.annotations.Param;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface AccountMapper {
    int register(@Param("user") AccountBody account);

    AccountDao login(@Param("body") LoginBody body);

    AccountDao wxLogin(@Param("body") LoginBody body);

    int query(@Param("body") LoginBody body);

    AccountDao queryById(@Param("id") int id);

    AccountDao queryByUid(@Param("uid") String uid);

    AccountEntity queryByPhone(@Param("phone") String phone);

    int queryId(@Param("phone") String phone);

    int updateAccount(@Param("body") LoginBody body);

    int reset(@Param("token") String token);

    int logout(int id);

    int total();

    int lastId();

}
