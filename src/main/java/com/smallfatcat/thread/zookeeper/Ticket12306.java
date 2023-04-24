//package com.smallfatcat.thread.zookeeper;
//
//import org.apache.curator.RetryPolicy;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.framework.recipes.locks.InterProcessLock;
//import org.apache.curator.framework.recipes.locks.InterProcessMutex;
//import org.apache.curator.retry.ExponentialBackoffRetry;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author zsz
// * zookeeper实现分布式锁
// * @date 2022/8/7
// */
//public class Ticket12306 implements Runnable{
//
//    //数据库里面的票数
//    private int tickets = 100;
//
//    private InterProcessLock lock;
//
//    //初始化lock锁
//    public Ticket12306(){
//        //重试策略
//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000,10);
//        //第二种链接方式
//        //namespace：命名空间，smallfatcat创建此节点
//        CuratorFramework client = CuratorFrameworkFactory.builder().
//                connectString("127.0.0.1:2181").
//                sessionTimeoutMs(60 * 1000).
//                connectionTimeoutMs(15 * 1000).
//                retryPolicy(retryPolicy).
//                build();
//        client.start();
//        lock = new InterProcessMutex(client,"/lock");
//    }
//
//    @Override
//    public void run() {
//        while (true){
//            //获取锁
//            try {
//                //等待3秒钟继续获取
//                lock.acquire(3, TimeUnit.SECONDS);
//                if(tickets > 0){
//                    System.out.println(Thread.currentThread()+":"+tickets);
//                    tickets--;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }finally {
//                //释放锁
//                try {
//                    lock.release();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    }
//}
