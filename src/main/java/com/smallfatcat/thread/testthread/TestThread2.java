package com.smallfatcat.thread.testthread;

/**
 * @author zsz
 * @date 2022/8/17
 */
public class TestThread2 {

    public static void main(String[] args) {

        final Business business = new Business();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int j = 1;j <= 50;j++) {
                            business.sub(j);
                        }
                    }
                }
        ).start();

        for(int j = 1;j <= 50;j++) {
            business.main(j);
        }

    }

}
class Business{
    private boolean lock = true;

    public synchronized void sub(int j){
        //判断lock的值是否为真
        //假的话走子线程
        if(!lock) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("子线程循环" + i + "第几次" + j);
        }
        //子线程走完将lock变为false，继续去走主线程
        lock = false;
        this.notify();
    }
    public synchronized void main(int j){
        //判断lock是否为真
        //真的话走主线程
        if(lock){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 100; i++) {
            System.out.println("主线程循环" + i + "第几次" + j);
        }
        lock = true;
        this.notify();
    }

}
