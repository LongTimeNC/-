package com.smallfatcat.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zsz
 * @Description
 * @date 2022/9/14
 */
public class AtomicIntegerDemo {
    static AtomicInteger at = new AtomicInteger(0);

    public static void main(String[] args) {
        for(int i = 0;i < 10000;i++){
            new Thread(()->{at.incrementAndGet();}).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count = " + at.get());
    }


}
