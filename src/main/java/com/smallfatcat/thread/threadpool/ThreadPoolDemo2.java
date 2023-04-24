package com.smallfatcat.thread.threadpool;

import java.util.concurrent.*;

/**
 * @author zsz
 * @Description-自定义线程池-测试特性
 * @date 2022/9/5
 */
public class ThreadPoolDemo2 {
    public static void main(String[] args) throws Exception {
        //1：创建线程池对象
        /**
         * public ThreadPoolExecutor(int corePoolSize,  核心线程数
         *                               int maximumPoolSize, 最大线程数量
         *                               long keepAliveTime,  存活时间
         *                               TimeUnit unit, 时间单元
         *                               BlockingQueue<Runnable> workQueue, 阻塞队列
         *                               ThreadFactory threadFactory, 线程工厂
         *                               RejectedExecutionHandler handler) 任务拒绝策略
         */
        ExecutorService pool = new ThreadPoolExecutor(3,5,6
                ,TimeUnit.SECONDS,new ArrayBlockingQueue<>(5)
                ,Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        //2：给任务线程池处理
        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        Future<String> f4 = pool.submit(new MyCallable(400));
        Future<String> f5 = pool.submit(new MyCallable(500));

        Future<String> f6 = pool.submit(new MyCallable(600));
        Future<String> f7 = pool.submit(new MyCallable(700));
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
        System.out.println(f5.get());
        System.out.println(f6.get());
        System.out.println(f7.get());
        pool.shutdownNow();

    }
}
