package com.smallfatcat.thread.CountDownLatch2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 此时三个工人在为老板干活，这个老板有一个习惯，
 * 就是当三个工人把一天的活都干完了的时候，他就来检查所有工人所干的活。
 * 记住这个条件：三个工人先全部干完活，老板才检查。
 */
public class TestLatch {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Worker worker1 = new Worker(latch, "张三");
        Worker worker2 = new Worker(latch, "李四");
        Worker worker3 = new Worker(latch, "王五");
        Worker worker4 = new Worker(latch, "赵六");
        Worker worker5 = new Worker(latch, "冯七");

        Boss boss = new Boss(latch);
        executorService.execute(worker1);
        executorService.execute(worker2);
        executorService.execute(worker3);
        executorService.execute(worker4);
        executorService.execute(worker5);
        executorService.execute(boss);

        executorService.shutdown();
    }
}
