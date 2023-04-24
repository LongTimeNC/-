package com.smallfatcat.thread.testthread;

import java.util.Random;

/**
 * @author zsz
 * ThreadLocal类
 * @date 2022/8/17
 */
public class TestThread4 {

    //实例化两个全局静态ThreadLocal类，并把线程里面的数据存放到里面
    private static ThreadLocal<Integer> a = new ThreadLocal<Integer>();
    private static ThreadLocal<MyThreadData> b = new ThreadLocal<MyThreadData>();

    public static void main(String[] args) {
        for(int i = 0;i < 2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data:" + data);
                    //直接放到当前线程里面
                    a.set(data);
                    //实例化封装的对象
                    //并把该实例存到ThreadLocal里面
//                    MyThreadData myThreadData = new MyThreadData();
//                    myThreadData.setName("name"+data);
//                    myThreadData.setAge(data);
//                    b.set(myThreadData);
                    MyThreadData.getInstance().setName("name" + data);
                    MyThreadData.getInstance().setAge(data);
                    //实例化A，B两个类并调用他们的get方法
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }
    static class A{
        public void get(){
            //ThreadLocal的get方法把存放在里面的实例对象取出来
//            MyThreadData myThreadData = b.get();
//            System.out.println("A"+Thread.currentThread().getName() + " get name:" + myThreadData.getName()
//            + ",get age:" + myThreadData.getAge());
            String name = MyThreadData.getInstance().getName();
            int age = MyThreadData.getInstance().getAge();
            System.out.println("A"+Thread.currentThread().getName() + " get name:" + name
                    + ",get age:" + age);
        }
    }
    static class B{
        public void get(){
//            MyThreadData myThreadData = b.get();
//            System.out.println("B"+Thread.currentThread().getName() + " get name:" + myThreadData.getName()
//            + ",get age:" + myThreadData.getAge());

            String name = MyThreadData.getInstance().getName();
            int age = MyThreadData.getInstance().getAge();
            System.out.println("A"+Thread.currentThread().getName() + " get name:" + name
                    + ",get age:" + age);
        }
    }

}
class MyThreadData{

//    private static MyThreadData instance = null;//new MyThreadData();
    private static ThreadLocal<MyThreadData> map = new ThreadLocal<MyThreadData>();

    public MyThreadData(){
    }
    //单例
    //使用单例模式创建类的实例
    public static  MyThreadData getInstance(){
        MyThreadData instance = map.get();
        if(instance == null){
            instance = new MyThreadData();
            map.set(instance);
        }
        return instance;
    }
    //封装属性，姓名和年龄
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
