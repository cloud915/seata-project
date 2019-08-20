package com.quick.demo.service.api.facade;

/**
 * @Description
 * @Author ghy
 * @Date 2019/8/20 14:24
 */
public interface AccountService {
    boolean addAccount(String uid,Double account);

    Double getAccount(String uid);
    boolean cleanAccount(String uid);

}
