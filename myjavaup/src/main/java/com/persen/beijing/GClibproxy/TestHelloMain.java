package com.persen.beijing.GClibproxy;

public class TestHelloMain {

    public static void main(String[] args) {
        CGlibProxy proxy = new CGlibProxy();
        Hello hello = (Hello) proxy.getProxy(Hello.class);
        String ret = hello.doHello("Bob", "dog");
        System.out.println(ret);
    }

}
