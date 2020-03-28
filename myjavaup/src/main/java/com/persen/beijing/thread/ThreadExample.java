package com.persen.beijing.thread;

public class ThreadExample {

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();
        Thread t2 = new Thread(new Thread2());
        t2.start();

        System.out.println(Thread.currentThread().getName());
        Thread[] ts = getAllThread();
        for (Thread t : ts) {
            System.out.println("Thread: " + t.getName() + " ID: " + t.getId()
                    + " running" + ", Priority: " + t.getPriority());
        }
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    System.out.println("Thread: " + getName() + " ID: "
                            + getId() + " currentThread:"
                            + Thread.currentThread().getId() + " running"
                            + ", Priority: " + getPriority());
                }
            }.start();
        }
    }

    public static Thread[] getAllThread() {
        ThreadGroup root = Thread.currentThread().getThreadGroup();
        ThreadGroup ttg = root;
        while ((ttg = ttg.getParent()) != null) {
            root = ttg;
        }
        Thread[] tlist = new Thread[(int) (root.activeCount() * 1.2)];
        return java.util.Arrays.copyOf(tlist, root.enumerate(tlist, true));
    }
}

class Thread1 extends  Thread {
    public void run() {
        System.out.println("thread1 begin");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread1 end");
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("thread2 begin");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread2 end");
    }
}