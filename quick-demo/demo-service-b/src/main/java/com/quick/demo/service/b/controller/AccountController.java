package com.quick.demo.service.b.controller;

import com.quick.demo.service.api.facade.AccountService;
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
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public boolean addOrder(String uid, Double account) {
        return accountService.addAccount(uid, account);
    }

    @GetMapping("/get")
    public Double getOrder(String uid) {
        return accountService.getAccount(uid);
    }

    @GetMapping("/clean")
    public boolean cleanOrder(String uid) {
        return accountService.cleanAccount(uid);
    }
}
