package com.smallfatcat.thread.thread3;

/**
 * @author zsz
 * @Description
 * @date 2022/9/2
 */
public class Police {
    public synchronized void say(Culprit c){    //加锁方法
        System.out.println("警察：你放了人质，我就放过你");
        c.fun();   //调用罪犯方法
    }
    public synchronized void fun(){    //加锁方法
        System.out.println("我救了人质，罪犯跑了");
    }

}
