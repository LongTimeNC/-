package com.smallfatcat.thread.ticket;

/**
 * @author zsz
 * @date 2022/8/17
 */
public class MyTicket implements Runnable {

    //共享数据
    private  int ticket = 100;

    @Override
    public void run() {
        sellTicket();
    }
    public  void sellTicket(){
        while(true) {
            synchronized (MyTicket.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "正在出售第:" + ticket + "长票");
                        ticket--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
