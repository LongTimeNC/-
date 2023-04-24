package com.smallfatcat.thread2.vol;

/**
 * 可见性:当有多个线程访问同一个变量时，一个线程对此变量的修改，其他线程应该立刻可获取到修改后的值。
 * 一个变量用volatile修饰后，当对此变量写入时，会立刻将写入后的值刷新到主存中，
 * 并且将其他线程本地内存中保存的值失效，其他线程读取此变量时，会直接从主内存中读取。
 */
public class VolatileDemo {
    private volatile static boolean stop = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while(stop){//无限循环
            }
        }).start();
        //确保上面线程先执行
        Thread.sleep(100);
        //虽然修改为false，但是上面线程依旧不会停
        stop = false;
        System.out.println("main thread end...");
    }
}
