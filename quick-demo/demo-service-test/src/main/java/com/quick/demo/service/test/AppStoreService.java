package com.quick.demo.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author ghy
 * @Date 2019/8/20 14:39
 */
@Service
public class AppStoreService {

    public static final String ORDER_ADD_URL = "http://localhost:8061/order/add";
    public static final String ORDER_GET_URL = "http://localhost:8061/order/get";
    public static final String ORDER_CLEAN_URL = "http://localhost:8061/order/clean";

    public static final String ACCOUNT_ADD_URL = "http://localhost:8062/account/add";
    public static final String ACCOUNT_GET_URL = "http://localhost:8062/account/get";
    public static final String ACCOUNT_CLEAN_URL = "http://localhost:8062/account/clean";

    @Autowired
    private RestTemplate restTemplate;

    public void sale() {
        String uid = "TEST001";
        Double account = Double.valueOf("200");

        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("uid", uid);
        paramMap.add("account", account);

        Boolean json = restTemplate.postForObject(ORDER_ADD_URL, paramMap, Boolean.class);
        System.out.println("ORDER_ADD_URL:" + json);
        if (json) {
            json = restTemplate.postForObject(ACCOUNT_ADD_URL, paramMap, Boolean.class);
            System.out.println("ACCOUNT_ADD_URL:" + json);
        }
    }

    public void show() {
        String uid = "TEST001";
        Map<String, String> mapInfo = new HashMap<>();
        mapInfo.put("uid", uid);
        String ordersJSON = restTemplate.getForObject(ORDER_GET_URL + "?uid={uid}", String.class, mapInfo);
        Double account = restTemplate.getForObject(ACCOUNT_GET_URL + "?uid={uid}", Double.class, mapInfo);

        System.out.println("orders:" + ordersJSON);
        System.out.println("account:" + String.valueOf(account.doubleValue()));

    }

    public void clean() {
        String uid = "TEST001";
        Map<String, String> mapInfo = new HashMap<>();
        mapInfo.put("uid", uid);
        Boolean ordersJSON = restTemplate.getForObject(ORDER_CLEAN_URL + "?uid={uid}", Boolean.class, mapInfo);
        Boolean account = restTemplate.getForObject(ACCOUNT_CLEAN_URL + "?uid={uid}", Boolean.class, mapInfo);

        System.out.println("clean data, orders:" + ordersJSON + ",account:" + account);
    }
}
