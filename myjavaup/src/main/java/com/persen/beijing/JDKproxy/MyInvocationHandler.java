package com.persen.beijing.JDKproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object obj, Method method, Object[] aobj)
            throws Throwable {
        System.out.println(obj.getClass());
        long begin = System.currentTimeMillis();
        Object ret = method.invoke(target, aobj);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        return ret;
    }

}
