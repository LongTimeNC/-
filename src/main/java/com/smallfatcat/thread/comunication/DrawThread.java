package com.smallfatcat.thread.comunication;

/**
 * @author zsz
 * @Description取钱线程类
 * @date 2022/9/5
 */
public class DrawThread extends Thread{
    private Account account;

    public DrawThread(Account account,String name){
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        //张三和李四消费者进行取钱，每次取1000
        //不断的进行取钱
        while (true){
            try {
                //取钱的速度慢一点
                Thread.sleep(1000);
                account.drawMoney(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
