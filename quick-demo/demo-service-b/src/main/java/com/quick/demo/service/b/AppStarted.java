package com.quick.demo.service.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author ghy
 * @Date 2019/8/20 11:30
 */
@SpringBootApplication
public class AppStarted {

    public static void main(String[] args) {
        SpringApplication.run(AppStarted.class,args);
        System.out.println("service-b is started");
    }
}
