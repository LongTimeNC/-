package com.smallfatcat.thread.ticket2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zsz
 * @date 2022/8/17
 */
public class MyTicket implements Runnable {

    //共享数据
    private  int ticket = 100;
    //创建一个锁对象
    //将ReentrantLock里面设置成true就是公屏锁
    //我们知道线程遇到锁后需排队等待锁开。
    // 而公平锁其实就是排队执行，等待锁开后，先来的线程先执行。
    // 而非公平锁是，锁一旦打开，所有线程一块抢，谁抢到谁执行。
    private Lock lock = new ReentrantLock(true);

    @Override
    public void run() {
        sellTicket();
    }
    public void sellTicket(){
        while(true) {
            lock.lock();
            try {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "正在出售第:" + ticket + "长票");
                        ticket--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        }
    }
}
