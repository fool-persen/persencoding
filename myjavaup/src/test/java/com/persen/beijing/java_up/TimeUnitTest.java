package com.persen.beijing.java_up;

import java.util.concurrent.TimeUnit;

public class TimeUnitTest {

    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(1);
            long mill = TimeUnit.MINUTES.toMillis(2);
            System.out.println(mill);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
