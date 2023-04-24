package com.smallfatcat.thread.ticket;

/**
 * @author zsz
 * @date 2022/8/17
 */
public class SellTicket {
    public static void main(String[] args) {

        MyTicket myTicket = new MyTicket();
        new Thread(myTicket,"携程").start();
        new Thread(myTicket,"飞猪").start();
        new Thread(myTicket,"12306官网").start();

    }
}
