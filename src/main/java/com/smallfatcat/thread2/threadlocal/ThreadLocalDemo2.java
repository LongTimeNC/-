package com.smallfatcat.thread2.threadlocal;

import java.util.stream.IntStream;

/**
 * @author zsz
 * @Description
 * @date 2022/9/8
 */
public class ThreadLocalDemo2 {
    public static void main(String[] args) {
        // new ThreadLocal();这样创建一个ThreadLocal的话，子线程是没有ThreadLocal的
//         ThreadLocal threadLocal = new ThreadLocal();
        // 如果我们希望子线可以看到父线程的ThreadLocal，那么就可以使用InheritableThreadLocal。
        // 顾名思义，这就是一个支持线程间父子继承的ThreadLocal，将上述代码中的threadLocal使用InheritableThreadLocal
        InheritableThreadLocal threadLocal = new InheritableThreadLocal();
        IntStream.range(0,10).forEach(i -> {
            //每个线程的序列号，希望在子线程中能够拿到
            threadLocal.set(i);
            //这里来了一个子线程，我们希望可以访问上面的threadLocal
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
