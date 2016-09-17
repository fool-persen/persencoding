package com.persen.beijing.tool;

public class JstatThread {

    public static void createThread() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true)
                    ;
            }
        }, "newnewThread");
        thread.start();
    }

    public static void main(String[] args) {
        createThread();
    }

}
