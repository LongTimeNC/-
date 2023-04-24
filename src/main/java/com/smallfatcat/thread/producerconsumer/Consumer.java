package com.smallfatcat.thread.producerconsumer;

/**
 * @author zsz
 * @Description
 * @date 2022/8/17
 */
public class Consumer implements Runnable{

    //提供一个成员变量
    private Box box;
    public Consumer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true){
            box.get();
        }
    }
}
