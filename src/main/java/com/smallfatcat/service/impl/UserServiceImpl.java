package com.smallfatcat.service.impl;

import com.smallfatcat.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author zsz
 * @Description
 * @date 2022/9/1
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void test() {
        System.out.println("test");
    }
}
