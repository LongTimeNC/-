package com.smallfatcat.thread.testthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zsz
 * 线程池
 * @date 2022/8/18
 */
public class ThreadPoolTest {


    public static void main(String[] args) {
        //三个线程的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 1; j <= 10; j++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "is lopping of: " + j + "for task: " + task);
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
