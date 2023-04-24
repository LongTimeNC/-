package com.smallfatcat.thread.CountDownLatch2;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{
    private CountDownLatch downLatch;
    private String name;

    public Worker(CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
    }


    @Override
    public void run() {
        this.work();
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(this.name + "活干完了...");
            this.downLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void work() {
        System.out.println(this.name + "正在干活...");
    }
}
