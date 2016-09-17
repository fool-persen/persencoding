package com.persen.beijing.cglib;

public class CGlibMain {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        SayHello say = (SayHello) proxy.getProxy(SayHello.class);
        say.say();//函数调用时被拦截
    }

}
