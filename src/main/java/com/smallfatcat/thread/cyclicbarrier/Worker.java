package com.smallfatcat.thread.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable{

    private CyclicBarrier cyclicBarrier;
    private String name;

    public Worker(CyclicBarrier cyclicBarrier,String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            this.work();
            Thread.sleep(new Random().nextInt(1000));
            this.waitOther();
            cyclicBarrier.await();
            this.continueWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


    private void work() {
        System.out.println(this.name + "正在干活...");
    }

    private void waitOther() {
        System.out.println(this.name + "当前这部分工作干完了，等等他们吧...");
    }
    private void continueWork() {
        System.out.println("大家都干完这部分活了," + this.name + "又得忙活了...");
    }

}
