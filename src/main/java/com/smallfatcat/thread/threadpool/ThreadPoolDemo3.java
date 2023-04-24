package com.smallfatcat.thread.threadpool;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zsz
 * @Description Executors工具方法直接获取一个线程对象
 * @date 2022/9/6
 */
public class ThreadPoolDemo3 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(new MyRunnable());
        threadPool.execute(new MyRunnable());
        threadPool.execute(new MyRunnable());
        threadPool.execute(new MyRunnable());//已经没有多余的线程了-阻塞了
    }
}
