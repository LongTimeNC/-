package com.smallfatcat.thread.ReentrantReadWriteLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
class DataContainer {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //获取写锁对象
    private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    //获取读锁对象
    private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
 
    private String s = "date";
 
    //读取数据，只要不涉及到写数据只要使用读锁即可
    public String getData() throws InterruptedException {
        String data = null;
        readLock.lock();
        try {
            data = s;
            log.debug("读取数据...");
            Thread.sleep(2000);
        } finally {
            readLock.unlock();
        }
        return data;
    }
    //读写线程分离
    public void setData(String data) throws InterruptedException {
        writeLock.lock();
        try {
            s = data;
            log.debug("写入数据...");
            Thread.sleep(200);
        } finally {
            writeLock.unlock();
        }
    }
}