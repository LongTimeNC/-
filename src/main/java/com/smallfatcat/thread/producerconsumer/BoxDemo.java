package com.smallfatcat.thread.producerconsumer;

/**
 * @author zsz
 * 生产者和消费者案例
 * @date 2022/8/17
 */
public class BoxDemo {
    public static void main(String[] args) {
        //共享变量-牛奶
        Box box = new Box();
        //开启两个线程
        new Thread(new Producer(box)).start();
        new Thread(new Consumer(box)).start();
        new Thread(new Consumer(box)).start();

    }
}
