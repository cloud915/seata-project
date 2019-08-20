package com.quick.demo.service.b.store;

import com.quick.demo.service.api.utils.MathUtil;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
public class AccountStore {

    private Map<String, Double> orders = new ConcurrentHashMap<>();

    public boolean put(String key, Double value) {
        try {
            Double currentVal;
            if (orders.keySet().contains(key)) {
                currentVal = orders.get(key);
            } else {
                currentVal = 1000D;
            }
            Double d = MathUtil.sub(currentVal, value);
            if (d >= 0) {
                orders.put(key, d);
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }


    public Double get(String key) {
        return orders.get(key);
    }


    public boolean clean(String uid) {
        orders.put(uid, 1000D);
        return true;
    }
}
