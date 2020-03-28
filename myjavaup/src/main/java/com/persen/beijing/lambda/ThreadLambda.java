package com.persen.beijing.lambda;

/**
 * Created by lijianyu on 2019/2/28.
 */
public class ThreadLambda {
    public static void main(String[] args) {
        GreetingService greetingService = dd -> System.out.println("111");
        new Thread(() -> {
            System.out.println("1");
            System.out.println("1");
        }).start();
    }
}
