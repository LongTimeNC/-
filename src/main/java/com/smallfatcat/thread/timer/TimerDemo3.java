package com.smallfatcat.thread.timer;

import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zsz
 * @Description-另一种定时器的创建方法
 * @date 2022/9/6
 */
public class TimerDemo3 {
    public static void main(String[] args) {
        //创建ScheduledExecutorService线程池，做定时器
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        //开启定时任务
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行A任务 ==>" + new Date());
                try {
                    //睡眠10s
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,2, TimeUnit.SECONDS);
        //开启定时任务
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行B任务 ==>" + new Date());
                //模拟B任务出错
                System.out.println(10 / 0);
            }
        },0,2, TimeUnit.SECONDS);
        //开启定时任务
        //即使B任务出错也不会影响C任务的执行
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行C任务 ==>" + new Date());
            }
        },0,2, TimeUnit.SECONDS);

    }
}
