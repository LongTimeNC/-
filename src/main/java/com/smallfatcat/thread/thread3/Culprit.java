package com.smallfatcat.thread.thread3;

/**
 * @author zsz
 * @Description
 * @date 2022/9/2
 */
public class Culprit {
    public synchronized void say(Police p){  //加锁方法
        System.out.println("罪犯：你放了我，我就放了人质");
        p.fun();  //调用警察方法
    }
    public synchronized void fun(){   //加锁方法
        System.out.println("我放了人质，警察也放了我");
    }

}
