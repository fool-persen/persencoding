package com.persen.beijing.thread;

public class JVMThreadTest {

    public static void main(String[] args) {
        Thread[] ts = getAllThread();
        for (Thread t : ts) {
            System.out.println(t.getId() + ": " + t.getName() + ", Priority: "
                    + t.getPriority());
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