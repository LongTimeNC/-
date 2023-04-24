package com.smallfatcat.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCycleBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        ExecutorService es = Executors.newCachedThreadPool();

        es.execute(new Worker(cyclicBarrier,"张三"));
        es.execute(new Worker(cyclicBarrier,"李四"));
        es.execute(new Worker(cyclicBarrier,"王五"));
        es.execute(new Worker(cyclicBarrier,"赵六"));
        es.execute(new Worker(cyclicBarrier,"冯七"));

        es.shutdown();
    }
}
