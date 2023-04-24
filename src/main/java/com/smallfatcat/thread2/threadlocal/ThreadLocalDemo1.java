package com.smallfatcat.thread2.threadlocal;

/**
 * @author zsz
 * @Description
 *
 * @date 2022/9/8
 */
public class ThreadLocalDemo1 {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    //将ThreadLocal的初始值设置为6，这对全体线程都是可见的。
    private static ThreadLocal<Integer> localInt = ThreadLocal.withInitial(() -> 6);


    public static void main(String[] args) {
        // 由于ThreadLocal里设置的值，只有当前线程自己看得见，这意味着你不可能通过其他线程为它初始化值。
        // 为了弥补这一点，ThreadLocal提供了一个withInitial()方法统一初始化所有线程的ThreadLocal的值：
        threadLocal.set(123);
        System.out.println(threadLocal.get());


    }
}
