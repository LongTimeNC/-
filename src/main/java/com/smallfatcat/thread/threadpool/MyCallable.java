package com.smallfatcat.thread.threadpool;

import java.util.concurrent.Callable;

/**
 * @author zsz
 * @Description
 * @date 2022/9/5
 */
public class MyCallable implements Callable<String> {

    private int n;
    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0;i <= n;i++){
            sum += i;
        }
        return Thread.currentThread().getName() + "执行1--" + n + "的和，结果是：" + sum;
    }
}
