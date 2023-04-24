package com.smallfatcat.thread.CountDownLatch2;

import java.util.concurrent.CountDownLatch;

public class Boss implements Runnable{

    private CountDownLatch downLatch;

    public Boss(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        System.out.println("包工头等待工人干完活...");
        try {
            this.downLatch.await();
            System.out.println("工人们已经干完活了，现在进行检查...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
