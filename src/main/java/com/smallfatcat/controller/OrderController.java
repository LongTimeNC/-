package com.smallfatcat.controller;

import com.smallfatcat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zsz
 * 测试单例多例
 * @date 2022/9/1
 */
@RestController
@Scope("prototype") //表示每次获得bean都会生成一个新的对象
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order1")
    public void test1(){
        System.out.println(this);
        System.out.println(orderService);
    }



}
