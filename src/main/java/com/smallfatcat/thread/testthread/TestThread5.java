package com.smallfatcat.thread.testthread;

/**
 * @author zsz
 * @date 2022/8/17
 */
public class TestThread5 {

    public static void main(String[] args) {
        final ShareDate1 shareDate2 = new ShareDate1();
        new Thread(new MyRunnable1(shareDate2)).start();
        new Thread(new MyRunnable2(shareDate2)).start();

        final ShareDate1 shareDate1 = new ShareDate1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                shareDate1.decrement();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                shareDate1.increment();
            }
        }).start();

    }
}
class MyRunnable1 implements Runnable{
    private ShareDate1 shareDate1;
    public MyRunnable1(ShareDate1 shareDate1){
        this.shareDate1 = shareDate1;
    }
    @Override
    public void run() {
        shareDate1.decrement();
    }
}
class MyRunnable2 implements Runnable{
    private ShareDate1 shareDate1;
    public MyRunnable2(ShareDate1 shareDate1){
        this.shareDate1 = shareDate1;
    }
    @Override
    public void run() {
        shareDate1.increment();
    }
}


class ShareDate1{

    private int j = 0;

    public synchronized void increment(){
        j++;
    }
    public synchronized void decrement(){
        j--;
    }

    private int count = 100;
//    @Override
//    public void run() {
//        while(true){
//
//            count--;
//        }
//    }
}
