package com.quick.demo.service.a.controller;

import com.quick.demo.service.api.facade.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author ghy
 * @Date 2019/8/20 14:03
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public boolean addOrder(String uid, Double account) {
        return orderService.addOrder(uid, account);
    }

    @GetMapping("/get")
    public List<String> getOrder(String uid) {
        return orderService.getOrder(uid);
    }
    @GetMapping("/clean")
    public boolean cleanOrder(String uid) {
        return orderService.cleanOrder(uid);
    }
}
