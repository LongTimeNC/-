package com.smallfatcat.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author zsz
 * @Description timer定时器的使用和了解
 * @date 2022/9/6
 */
public class TimerDemo1 {
    public static void main(String[] args) {
        //定时器本身就是一个单线程
        //1:创建Timer定时器
        Timer timer = new Timer();
        //调用方法处理定时任务
        //刚开始3s执行一次，再然后每隔2s执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行一次");
            }
        },3000,2000);

    }
}
