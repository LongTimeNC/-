package com.smallfatcat.controller;

import com.smallfatcat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zsz
 * 测试Autowired和Resource
 * @date 2022/9/1
 */
@RestController
public class UserController {

    /**
     * @Autowired 会先按照类型来进行装配,如果找不到，就报错，找到一个就注入，如果有多个,在按照名称来装配，找不到就报错
     * ---spring提供的
     */
    @Autowired
    private UserService userServiceImpl;


    @GetMapping("/user1")
    public void test1(){
        userServiceImpl.test();
    }
    /**
     * @Resource 会先按照名称来进行装配,如果找到就注入，如果找不到bean在按照类型来装配，如果找到多个或者找不到就报错，如果找到一个就注入
     * ---JDK提供的
     */
    @Resource(name = "userService")
    private UserService userService;
    @GetMapping("/user2")
    public void test2(){
        userService.test();
    }


}
