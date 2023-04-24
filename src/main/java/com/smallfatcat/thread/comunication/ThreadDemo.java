package com.smallfatcat.thread.comunication;

/**
 * @author zsz
 * @Description了解线程通信的流程
 * @date 2022/9/5
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //使用3个爸爸存钱(生产者)，2个孩子(消费者)取钱模拟线程通信思想（一个存钱，一个取钱）
        //1：创建共享资源，存取账户，代表5个线程的共享资源
        Account account = new Account("ICBC-110",0);
        //2：创建2个取钱线程代表张三和李四
        new DrawThread(account,"张三").start();
        new DrawThread(account,"李四").start();
        //3：创建3个存钱线程代表亲爹干爹和岳父
        new DepositThread(account, "亲爹").start();
        new DepositThread(account, "干爹").start();
        new DepositThread(account, "岳父").start();


    }
}
