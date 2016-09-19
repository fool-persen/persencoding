package com.persen.beijing.JDKproxy;

import java.lang.reflect.Proxy;

public class TestServiceMain {

    public static void main(String[] args) {
        Service ss = (Service) Proxy.newProxyInstance(TestServiceMain.class
                        .getClassLoader(), ServiceImpl.class.getInterfaces(),//new Class[] { Service.class },
                new MyInvocationHandler(new ServiceImpl()));

        String ret = ss.doFunction("Boss", "go");
        System.out.println(ret);

        String ret1 = ss.doFunction1("Boss1", "go1");
        System.out.println(ret1);
    }
}
