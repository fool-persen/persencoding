package com.persen.beijing.thread;

import java.util.concurrent.CountDownLatch;

import static javafx.scene.input.KeyCode.T;

public class Volatile {

    public volatile static int count = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(1000);

    public static void inc() {

        // 这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }

        count++;
    }

    public static void main(String[] args) {

        // 同时启动1000个线程，去进行i++计算，看看实际结果

        for (int i = 0; i < 1000; i++)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Volatile.inc();
                    countDownLatch.countDown();
                }
            }).start();

        try {
            countDownLatch.await();
            //Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + Volatile.count);
    }
}
