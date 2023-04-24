package com.smallfatcat.thread.condition;

class MyThread1 implements Runnable {

    private ConditionDemo conditionDemo;

    public MyThread1(ConditionDemo conditionDemo) {
        this.conditionDemo = conditionDemo;

    }

    @Override

    public void run() {

        while (true) {
            conditionDemo.thread1();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
