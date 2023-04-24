package com.smallfatcat.thread.comunication;

/**
 * @author zsz
 * @Description共享账户-代表共享资源
 * @date 2022/9/5
 */
public class Account {
    private String cardId;
    private double money;

    /**
     * 线程通信的前提要保证线程安全-synchronized
     * 账户对象里面的取钱方法
     * 消费者都会通过该方法进行取钱
     * @param money
     */
    public synchronized void drawMoney(double money){
        try {
            //得到取钱者的名字
            String name = Thread.currentThread().getName();
            if(this.money >= money){
                //钱够用，可以取钱
                this.money -= money;
                System.out.println(name + "来取钱" + money + "成功! 取钱后余额是:" + this.money);
                //没钱了，唤醒别人，等待自己
                this.notifyAll();
                this.wait();
            }else {
                //钱不够，不可取钱
                //唤醒别人，等待自己

                //唤醒所有线程
                this.notifyAll();

                //锁对象，让当前线程进入等待
                this.wait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 线程通信的前提要保证线程安全-synchronized
     * 三个线程同时存钱
     * @param money
     */
    public synchronized void saveMoney(double money){
        try {
            //得到存钱者的名字
            String name = Thread.currentThread().getName();
            if(this.money == 0){
                //说明账户里面没钱了，存钱
                this.money += money;
                System.out.println(name + "存钱" + money + "成功! 存钱后余额:" + this.money);
                //存入钱有钱了，就应该唤醒别人，等待自己
                this.notifyAll();
                this.wait();
            }else {
                //有钱不存钱
                this.notifyAll();
                this.wait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public Account() {
    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardId='" + cardId + '\'' +
                ", money=" + money +
                '}';
    }
}
