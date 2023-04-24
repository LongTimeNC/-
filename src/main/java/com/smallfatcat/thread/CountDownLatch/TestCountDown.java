package com.smallfatcat.thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;

//测试类------说明主线程await以后，必须等待这五个线程运行结束才会执行
public class TestCountDown {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch await = new CountDownLatch(5);
        for (int i = 1; i < 6; i++) {
            new Thread(new MyRunnable(await, i)).start();
        }

        System.out.println("等待线程运行结束...");
        await.await();
        System.out.println("五个线程已经运行结束...");

    }
}
