package com.smallfatcat.thread.condition2;

class Thread3 implements Runnable {

    private ConditionDemo2 demo;

    public Thread3(ConditionDemo2 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            demo.c();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}