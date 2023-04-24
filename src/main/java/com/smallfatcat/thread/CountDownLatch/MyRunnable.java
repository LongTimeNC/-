package com.smallfatcat.thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;

//MyRunnable类
public class MyRunnable implements Runnable{

    private final CountDownLatch await;
    private final int num;

    public MyRunnable(CountDownLatch await, int num) {
        this.await = await;
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("线程" + num + "执行完毕...");
        await.countDown();   //当前事件执行完毕，计数减1
    }
}

