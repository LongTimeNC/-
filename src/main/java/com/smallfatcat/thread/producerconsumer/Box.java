package com.smallfatcat.thread.producerconsumer;

/**
 * @author zsz
 * @Description
 * @date 2022/8/17
 */
public class Box {
    //定义一个成员变量，表示第几瓶奶
    private int milk;
    //定义一个成员变量，表示奶箱的状态
    private boolean state = false;

    //提供存储牛奶和获取牛奶的操作
    public synchronized void put(int milk){
        //加一个奶箱状态
        //如果有牛奶，等待消费
        if (state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有牛奶，送奶工将牛奶放入奶箱，生产牛奶
        this.milk = milk;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("送奶工将第"+this.milk+"瓶奶放入奶箱");
        //然后将状态变为true，有牛奶
        state = true;
        //唤醒其他线程
        notifyAll();
    }
    public synchronized void get(){
        //如果没有牛奶
        //等待生产
        if(!state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果奶箱有牛奶就消费牛奶
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("用户拿到第"+this.milk+"瓶奶");
        //消费完毕之后修改奶箱状态
        state = false;
        //唤醒其他线程
        notifyAll();
    }

}
