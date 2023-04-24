package com.smallfatcat.thread.threadpool;

/**
 * @author zsz
 * @Description
 * @date 2022/9/5
 */
public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 1;i <= 5;i++){
            System.out.println(Thread.currentThread().getName() + "输出了HelloWorld ==>" + i);
        }
        try {
            System.out.println(Thread.currentThread().getName() + "本任务与线程绑定了，线程进行休眠了");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
