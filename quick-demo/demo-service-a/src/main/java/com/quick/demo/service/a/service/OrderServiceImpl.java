package com.quick.demo.service.a.service;

import com.alibaba.fastjson.JSON;
import com.quick.demo.service.a.store.OrderStore;
import com.quick.demo.service.api.entity.OrderEntity;
import com.quick.demo.service.api.facade.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description
 * @Author ghy
 * @Date 2019/8/20 14:06
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderStore orderStore;

    @Override
    public boolean addOrder(String uid, Double account) {
        OrderEntity orderEntity = new OrderEntity(uid, UUID.randomUUID().toString(),"cargoName", account, new Date());
        return orderStore.put(uid, JSON.toJSONString(orderEntity));
    }

    @Override
    public List<String> getOrder(String uid) {
        return orderStore.get(uid);
    }

    @Override
    public boolean cleanOrder(String uid) {
        return orderStore.clean(uid);
    }
}
