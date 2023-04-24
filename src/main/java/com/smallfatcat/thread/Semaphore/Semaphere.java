package com.smallfatcat.thread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
//信号灯
public class Semaphere {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore sp = new Semaphore(3);//3个灯
        for (int i=0;i<10;i++){
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    try {
                        sp.acquire();//获得一盏灯
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"进入,当前已有"+(3-sp.availablePermits())+"占用灯");
                    try {
                        Thread.sleep((long)(Math.random()*10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"即将离开");
                    sp.release();
                    System.out.println("线程"+Thread.currentThread().getName()+"已经离开,当前已有"+(3-sp.availablePermits())+"占用灯");


                }
            };
            executorService.execute(runnable);
        }

    }
}
