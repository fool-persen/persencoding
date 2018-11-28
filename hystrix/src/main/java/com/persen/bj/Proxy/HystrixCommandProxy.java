package com.persen.bj.Proxy;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * Created by lijianyu on 2018/11/3.
 */
public class HystrixCommandProxy implements InvocationHandler {

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        method.invoke(o, null);
        return null;
    }

    private HystrixCommand target;

    public Object getInstance(HystrixCommand hystrixCommand) {
        this.target = hystrixCommand;
        return Proxy.newProxyInstance(hystrixCommand.getClass().getClassLoader(), hystrixCommand.getClass().getInterfaces(), this);
    }

}
