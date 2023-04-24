package com.smallfatcat.thread.testthread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zsz
 * 线程范围内共享变量的概念与作用
 * @date 2022/8/17
 */
public class TestThread3 {

    private static int data = 0;
    private static Map<Thread,Integer> map = new HashMap<Thread,Integer>();

    public static void main(String[] args) {
        for(int i = 0;i < 2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data:" + data);
                    //hread.currentThread()：当前线程，map集合一个key一个value
                    map.put(Thread.currentThread(),data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }

    }
    static class A{
        public void get(){
            int data = map.get(Thread.currentThread());
            System.out.println("A"+Thread.currentThread().getName() + " get data:" + data);
        }
    }
    static class B{
        public void get(){
            int data = map.get(Thread.currentThread());
            System.out.println("B"+Thread.currentThread().getName() + " get data:" + data);
        }
    }

}
