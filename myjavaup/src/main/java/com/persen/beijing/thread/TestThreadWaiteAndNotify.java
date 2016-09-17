package com.persen.beijing.thread;

public class TestThreadWaiteAndNotify {

    private static Object obj = new Object();

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Thread2 t2 = new Thread2();
        t2.start();
    }

    static class Thread1 extends Thread {
        public void run() {
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("线程" + this.getName() + "获取到了锁");
            }

        }
    }

    static class Thread2 extends Thread {
        public void run() {
            synchronized (obj) {
                obj.notify();
                System.out
                        .println("线程" + this.getName() + "调用了object.notify()");
            }
            System.out.println("线程" + this.getName() + "释放了锁");
        }
    }
}
