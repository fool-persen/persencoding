package com.persen.beijing.thread;

public class TestSynchronized extends Thread {

    private int val;
    private static Object lock = new Object();

    public TestSynchronized(int v) {
        val = v;
    }

    public void pringVal(int v) {
        synchronized (lock) {
            while (true)
                System.out.println(v);
        }
    }

    public synchronized static void pringVal1(int v) {

        while (true)
            System.out.println(v);

    }

    @Override
    public void run() {
        pringVal1(val);
    }

    public static void main(String[] args) {
        TestSynchronized ts1 = new TestSynchronized(1);

        TestSynchronized ts2 = new TestSynchronized(2);
        ts2.start();
        ts1.start();
    }
}
