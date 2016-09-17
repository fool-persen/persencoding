package com.persen.beijing.thread;

public class ThreadExample {

    public static void main(String[] args) {
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