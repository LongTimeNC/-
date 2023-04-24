package com.smallfatcat.thread.condition2;

class Thread2 implements Runnable {

    private ConditionDemo2 demo;

    public Thread2(ConditionDemo2 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            demo.b();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
