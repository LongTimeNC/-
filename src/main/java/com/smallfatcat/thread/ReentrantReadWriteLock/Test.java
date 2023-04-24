package com.smallfatcat.thread.ReentrantReadWriteLock;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zsz
 * @Description
 * @date 2022/9/6
 */
@Slf4j
public class Test {
    public static void main(String[] args) throws InterruptedException {
        DataContainer dc = new DataContainer();
        new Thread(() -> {
            try {
                log.debug("{}", dc.getData());
                System.out.println(dc.getData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                log.debug("{}", dc.getData());
                System.out.println(dc.getData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
        //10:35:01.435 [t2]  读取数据...
        //10:35:01.435 [t1]  读取数据...
        //10:35:03.445 [t2]   date
        //10:35:03.445 [t1]   date
    }
}
