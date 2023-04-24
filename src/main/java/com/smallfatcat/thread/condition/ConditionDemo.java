package com.smallfatcat.thread.condition;

import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ConditionDemo
 * @Description: 使用Condition保证线程的执行顺序
 * @Author: liuhefei
 * @Date: 2019/4/11
 * @blog: https://www.imooc.com/u/1323320/articles
 **/

public class ConditionDemo {

    private int signal;
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();


    //线程1
    public void thread1() {
        lock.lock();   //加锁
        while (signal != 0) {
            try {
                c1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("thread1....");

        signal++;
        System.out.println(signal);
        c2.signal();  //唤醒线程2

        lock.unlock();   //释放锁

    }
    //线程2
    public void thread2() {
        lock.lock();  //加锁
        while (signal != 1) {
            try {
                c2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("thread2....");

        signal++;
        System.out.println(signal);
        c3.signal();   //唤醒线程3

        lock.unlock();  //释放锁

    }

    //线程3
    public void thread3() {
        lock.lock();   //加锁
        while (signal != 2) {
            try {
                c3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("thread3....");

        signal = 0;
        System.out.println(signal);
        c1.signal();  //唤醒线程1

        lock.unlock();  //释放锁

    }

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();
        MyThread1 my1 = new MyThread1(conditionDemo);
        MyThread2 my2 = new MyThread2(conditionDemo);
        MyThread3 my3 = new MyThread3(conditionDemo);

        new Thread(my1).start();
        new Thread(my2).start();
        new Thread(my3).start();

    }

}
