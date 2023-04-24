package com.smallfatcat.thread.producerconsumer;

/**
 * @author zsz
 * @Description
 * @date 2022/8/17
 */
public class Producer implements Runnable{
    //提供一个成员变量
    private Box box;
    public Producer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 1;i <= 10;i++){
            box.put(i);
        }
    }
}
