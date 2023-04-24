package com.smallfatcat.thread.condition;

class MyThread2 implements Runnable {

    private ConditionDemo conditionDemo;

    public MyThread2(ConditionDemo conditionDemo) {
        this.conditionDemo = conditionDemo;
    }

    @Override

    public void run() {

        while (true) {
            conditionDemo.thread2();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
