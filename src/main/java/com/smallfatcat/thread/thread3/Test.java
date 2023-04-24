package com.smallfatcat.thread.thread3;

/**
 * @author zsz
 * @Description
 * @date 2022/9/2
 */
public class Test {
    public static void main(String[] args) {
        Culprit culprit = new Culprit();
        Police police = new Police();
        //new子线程
        new Thread(new MyRunnable(culprit,police)).start();
        //主线程用罪犯调用say，想得到警察的fun方法回应
        /**
         * 在主线程启动后，罪犯调用了say方法，此时子线程启动了。
         * 子线程便锁住，主线程就无法得到警察的fun方法回应。
         * 得不到回应，主线程就没有执行完，便不会解锁。
         * 不解锁，那么子线程的警察也无法得到罪犯的fun方法回应，也无法解锁。所以死锁。
         */
        culprit.say(police);
    }
}
