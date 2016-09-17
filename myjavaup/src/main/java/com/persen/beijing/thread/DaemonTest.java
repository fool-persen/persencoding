package com.persen.beijing.thread;

import java.io.IOException;

public class DaemonTest {

    public static void main(String[] args) throws InterruptedException,
            IOException {
        Thread daemon = new Thread(new DaemonThread());
        daemon.setName("My Daemon Thread");
        daemon.setDaemon(true);
        daemon.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread: " + i);
            Thread.sleep(1000);
        }
    }
}

class DaemonThread implements Runnable {
    private int index = 0;

    @Override
    public void run() {
        while (index < 100) {
            System.out.println("========= Daemon thread: " + index++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}