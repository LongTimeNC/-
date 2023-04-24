package com.smallfatcat.thread.testthread;

/**
 * @author zsz
 *
 * @date 2022/8/17
 */
public class TestThread1 {

    public static void main(String[] args) {
        //实例化内部类
        //调用init方法，开启两个线程
        new TestThread1().init();
    }

    private void init(){
        //实例化
        final Outputer outputer = new Outputer();

        //开启一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("LiPeiLiang");
                }
            }
        }).start();
        //开启一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output("ZhangMin");
                }
            }
        }).start();
    }

    //内部类
    class Outputer{
        //内部类的打印输出方法
        public void output(String name){
            //初始化一把锁
            //String lock = "lock";
            //这样两个线程调用此方法的时候用的都是同一把锁
            //this：this指内部类Outputer，所以还是同一把锁
            synchronized (this){
                for(int i = 0;i < name.length();i++){
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }
        //内部类的打印输出方法
        //修饰方法使用：synchronized，也可以实现线程同步
        public synchronized void output2(String name){
            for(int i = 0;i < name.length();i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }



    }
}
