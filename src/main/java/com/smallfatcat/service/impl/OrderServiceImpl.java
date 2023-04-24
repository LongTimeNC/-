package com.smallfatcat.service.impl;

import com.smallfatcat.service.OrderService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zsz
 * @Description
 * @date 2022/9/1
 */
@Service
@Scope("prototype") //表示每次获得bean都会生成一个新的对象
public class OrderServiceImpl implements OrderService {
    /*
     * 捕获异常时，要想使事务生效，需要手动抛出RuntimeException异常或者添加rollbackFor = Exception.class
     */
    @Override
    @Transactional
    public void test1() {
        try {
            int i = 1/0;
            System.out.println("test");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("运行时异常");
        }
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void test2() {
        try {
            int i = 1/0;
            System.out.println("test");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
