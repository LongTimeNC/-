package com.smallfatcat.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntengerDemo {
 
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(10);
 
        //获取自增后的值
        int a = ai.incrementAndGet();
 
        //获取自增之前的值
        int a1 = ai.getAndIncrement();
 
        //获取自减后的值
        int a2 = ai.decrementAndGet();
 
        //获取自减前的值
        int a3 = ai.getAndDecrement();
 
        //获取当前的值
        int a4 = ai.get();
 
        //先相加再取值
        int a5 = ai.addAndGet(15);
 
        //先取值再相加
        int a6 = ai.getAndAdd(15);
 
        //改变当前的值
        ai.set(55);
 
        //获得改变之前的值
        int a7 = ai.getAndSet(10);
 
 
        //也就是说如果当前值等于10，就改变当前值为15，返回true反之返回false并且不对值进行修改
        //相当于
        // if (this == expect) {
        //    this = update
        //    return true;
        //} else {
        //    return false;
        //}
        boolean a8 = ai.compareAndSet(10,15);
 
        System.out.println(a8+"----"+ai.get());
    }
}