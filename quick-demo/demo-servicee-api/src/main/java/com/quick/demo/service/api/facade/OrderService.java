package com.quick.demo.service.api.facade;

import java.util.List;

/**
 * @Description
 * @Author ghy
 * @Date 2019/8/20 14:05
 */
public interface OrderService {
    boolean addOrder(String uid,Double account);
    List<String> getOrder(String uid);
    boolean cleanOrder(String uid);
}
