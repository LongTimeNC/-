package com.smallfatcat.AtomicInteger;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zsz
 */
public class AtomicIntegerDetailTest {
    /**
     * AtomicInteger特点：
     * 1、保证可见性
     * 2、保证有序性
     * 3、保证原子性
     */
    public static void main(String[] args) {
        //1、value.get()获取当前value的值，无锁
        AtomicInteger get = new AtomicInteger();
        System.out.println("value：" + get.get());
        get = new AtomicInteger(10);
        System.out.println("value：" + get.get());

        //2、value.set(value)是设置值，无锁，多线程使用会出问题，一般用于初始化数值
        AtomicInteger set = new AtomicInteger();
        set.set(50);
        System.out.println("value：" + set.get());

        //3、获取旧的值（当前值），重新设置新的值
        AtomicInteger getAndSet = new AtomicInteger();
        int oldValue = getAndSet.getAndSet(80);
        int newValue = getAndSet.get();
        System.out.println("旧值：" + oldValue);
        System.out.println("新值：" + newValue);

        //4、如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。
        // 这里需要注意的是这个方法的返回值实际上是是否成功修改，而与之前的值无关
        AtomicInteger compareAndSet = new AtomicInteger(10);
        boolean result = compareAndSet.compareAndSet(10,30);
        System.out.println("result：" + result);
        System.out.println("value：" + compareAndSet.get());

        //5、先获取当前值再进行自增
        AtomicInteger getAndIncrement = new AtomicInteger(10);
        int newValue1 = getAndIncrement.getAndIncrement();
        System.out.println("newValue1：" + newValue1);
        System.out.println("value：" + getAndIncrement.get());

        //6、先获取当前值再进行自减
        AtomicInteger getAndDecrement = new AtomicInteger(10);
        int newValue2 = getAndDecrement.getAndDecrement();
        System.out.println("newValue2：" + newValue2);
        System.out.println("value：" + getAndDecrement.get());

        //7、先获取当前值再加上指定值
        AtomicInteger getAndAdd = new AtomicInteger(10);
        int newValue3 = getAndAdd.getAndAdd(5);
        System.out.println("newValue3：" + newValue3);
        System.out.println("value：" + getAndAdd.get());

        //8、先自增再获取当前值
        AtomicInteger incrementAndGet = new AtomicInteger(10);
        int newValue4 = incrementAndGet.incrementAndGet();
        System.out.println("newValue4：" + newValue4);
        System.out.println("value：" + incrementAndGet.get());

        //9、先自减再获取当前值
        AtomicInteger decrementAndGet = new AtomicInteger(10);
        int newValue5 = decrementAndGet.decrementAndGet();
        System.out.println("newValue5：" + newValue5);
        System.out.println("value：" + decrementAndGet.get());

        //10、先加上指定值再获取当前值
        AtomicInteger addAndGet = new AtomicInteger(10);
        int newValue6 = addAndGet.addAndGet(5);
        System.out.println("newValue6：" + newValue6);
        System.out.println("value：" + addAndGet.get());



    }
}

