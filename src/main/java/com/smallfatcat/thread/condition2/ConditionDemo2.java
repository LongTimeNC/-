package com.smallfatcat.thread.condition2;

import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ConditionDemo2
 * @Description: 使用condition按顺序唤醒线程
 * @Author: liuhefei
 * @Date: 2019/5/12
 * @blog: https://www.imooc.com/u/1323320/articles
 **/

public class ConditionDemo2 {

    private int signal;   //信号

    Lock lock = new ReentrantLock();

    Condition a = lock.newCondition();

    Condition b = lock.newCondition();

    Condition c = lock.newCondition();

    public void a() {
        lock.lock();
        while (signal != 0) {
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a...");

        signal++;

        b.signal();   //唤醒b

        lock.unlock();

    }

    public synchronized void b() {
        lock.lock();
        while (signal != 1) {
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b...");

        signal++;

        c.signal();   //唤醒c

        lock.unlock();

    }

    public synchronized void c() {
        lock.lock();
        while (signal != 2) {
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c...");

        signal = 0;

        a.signal();  //唤醒a

        lock.unlock();

    }

    public static void main(String[] args) {

        ConditionDemo2 d = new ConditionDemo2();

        Thread1 a = new Thread1(d);

        Thread2 b = new Thread2(d);

        Thread3 c = new Thread3(d);

        new Thread(a).start();

        new Thread(b).start();

        new Thread(c).start();

    }

}
