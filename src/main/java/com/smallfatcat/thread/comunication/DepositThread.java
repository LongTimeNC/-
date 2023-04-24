package com.smallfatcat.thread.comunication;

/**
 * @author zsz
 * @Description存钱类线程
 * @date 2022/9/5
 */
public class DepositThread extends Thread{

    private Account account;

    public DepositThread(Account account,String name){
        super(name);
        this.account = account;
    }


    @Override
    public void run() {
        //存钱方法，每次存1000，存放15次
        for (int i = 1;i <= 15;i++){
            try {
                //让存钱的速度慢一点
                Thread.sleep(2000);
                account.saveMoney(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
