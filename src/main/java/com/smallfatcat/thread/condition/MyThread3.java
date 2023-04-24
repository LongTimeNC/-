package com.smallfatcat.thread.condition;

class MyThread3 implements Runnable {

    private ConditionDemo conditionDemo;

    public MyThread3(ConditionDemo conditionDemo) {

        this.conditionDemo = conditionDemo;

    }

    @Override

    public void run() {

        while (true) {
            conditionDemo.thread3();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
