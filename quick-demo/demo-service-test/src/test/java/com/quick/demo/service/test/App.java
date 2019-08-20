package com.quick.demo.service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description
 * @Author ghy
 * @Date 2019/8/20 14:34
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class App {

    @Autowired
    private AppStoreService appStoreService;

    @Test
    public void saleTest() {
        appStoreService.sale();
    }
    @Test
    public void showTest() {
        appStoreService.show();
    }
    @Test
    public void celanTest() {
        appStoreService.clean();
    }

}
