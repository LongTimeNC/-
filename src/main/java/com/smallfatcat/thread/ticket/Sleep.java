package com.smallfatcat.thread.ticket;

/**
 * @author zsz
 * @Description
 * @date 2022/8/18
 */
public class Sleep {
    public static void main(String[] args) {
        for (int i = 1;i <= 5;i++){
            System.out.println("输出：" + i);
            if(i == 3){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
