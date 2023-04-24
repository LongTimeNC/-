package com.smallfatcat.AtomicInteger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zsz
 * @Description
 * @date 2022/9/14
 */
public class AtomicIntegerDemo2 {
    static ConcurrentMap<Integer, AtomicInteger> jobTimeoutCountMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        //分10个线程，每个线程自增2000次
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 2000; i++) {

                        AtomicInteger timeoutCount = jobTimeoutCountMap.putIfAbsent(22, new AtomicInteger(1));
                        if (timeoutCount != null) {
                            // 记录慢任务慢的次数
                            timeoutCount.incrementAndGet();
                        }
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(jobTimeoutCountMap.get(22));
    }


}
