package com.smallfatcat.thread2.vol;

/**
 * 指令重排序:编译器有时会为了效率，在保证不影响最终结果的前提下，会改变代码的执行顺序。
 * 在单线程下，不会存在问题，但是在多线程下就会带来一些问题，比如单例模式中，双重锁校验，锁的对象必须用volatile修改。
 * 单例模式：双重锁校验
 */
public class DoubleCheck {
    private static volatile DoubleCheck doubleCheck = null;
    private DoubleCheck() {
    }
    public static DoubleCheck getInstance() {
        //第一次校验
        if (doubleCheck == null) {
            synchronized (DoubleCheck.class) {
                //第二次校验
                if (doubleCheck == null) {
                    doubleCheck = new DoubleCheck();
                }
            }
        }
        return doubleCheck;
    }
}
