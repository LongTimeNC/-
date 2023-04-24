package com.smallfatcat.thread.threadpool;

import java.util.concurrent.*;

/**
 * @author zsz
 * @Description-自定义线程池-测试特性
 * @date 2022/9/5
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
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
        MyRunnable target = new MyRunnable();
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        //创建临时线程
        pool.execute(target);
        pool.execute(target);
//        //不创建，拒绝策略被触发
//        pool.execute(target);

        //关闭线程池-（开发中一般不使用）
//        //立即关闭线程池，即使任务没有完成，会丢失任务
//        pool.shutdownNow();
        //等待任务全部执行完毕之后，关闭线程池
        pool.shutdown();

    }
}
