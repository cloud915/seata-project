package com.quick.demo.service.a.store;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description
 * @Author ghy
 * @Date 2019/8/20 14:07
 */
@Component
public class OrderStore {

    private Map<String, List<String>> orders = new ConcurrentHashMap<>();

    public boolean put(String key, String value) {
        try {
            if (orders.keySet().contains(key)) {
                orders.get(key).add(value);
            } else {
                List<String> list = new LinkedList<>();
                list.add(value);
                orders.put(key, list);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<String> get(String key) {
        return orders.get(key);
    }

    public boolean clean(String uid) {
        if (orders.keySet().contains(uid)) {
            orders.get(uid).clear();
        }
        return true;
    }
}
