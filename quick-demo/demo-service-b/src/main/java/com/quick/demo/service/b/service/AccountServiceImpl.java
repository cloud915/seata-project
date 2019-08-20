package com.quick.demo.service.b.service;

import com.quick.demo.service.api.facade.AccountService;
import com.quick.demo.service.b.store.AccountStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description
 * @Author ghy
 * @Date 2019/8/20 14:06
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountStore accountStore;

    @Override
    public boolean addAccount(String uid, Double account) {
        return accountStore.put(uid, account);
    }

    @Override
    public Double getAccount(String uid) {
        return accountStore.get(uid);
    }

    @Override
    public boolean cleanAccount(String uid) {
        return accountStore.clean(uid);
    }
}
