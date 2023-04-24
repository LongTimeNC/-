package com.smallfatcat.thread.condition3;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ConditionTest2 {

    public static void main(String[] args) {
        BoundedContainer bc = new BoundedContainer();

        IntStream.range(0, 15).forEach(i -> new Thread(() -> {
            System.out.println(bc.take());
        }).start());

        IntStream.range(0, 15).forEach(i -> new Thread(() -> {
            bc.put("元素" + i);
        }).start());
    }

}

class BoundedContainer {
    private String[] elements = new String[10];
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    // element count
    private int count;
    private int putIndex, takeIndex;

    void put(String element) {
        this.lock.lock();
        try {
            while (this.count == this.elements.length) {
                notFull.await();
            }
            elements[putIndex] = element;

            if (++putIndex == this.elements.length) {
                putIndex = 0;
            }
            ++count;

            System.out.println("put method: " + Arrays.toString(elements));
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
    }

    String take() {
        this.lock.lock();
        try {
            while (this.count == 0) {
                notEmpty.await();
            }

            String element = elements[takeIndex];
            elements[takeIndex] = null;
            if (++takeIndex == this.elements.length) {
                takeIndex = 0;
            }
            --count;

            System.out.println("take method: " + Arrays.toString(elements));
            notFull.signal();

            return element;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
        return null;
    }
}

