package com.smallfatcat.thread.thread3;

/**
 * @author zsz
 * @Description
 * @date 2022/9/2
 */
public class MyRunnable implements Runnable{
    Culprit culprit = new Culprit();
    Police police = new Police();
    public MyRunnable(Culprit culprit,Police police){
        this.culprit = culprit;
        this.police = police;
    }
    @Override
    public void run() {
        police.say(culprit);  //在子线程中用警察调用say，想得到罪犯的fun方法回应
    }
}
