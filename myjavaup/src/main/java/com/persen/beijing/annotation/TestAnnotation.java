package com.persen.beijing.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class TestAnnotation {

    @MyAnnotation(name = "zhangsan")
    public static void say(final String name) {
        System.out.println("  ~~~~~~~~~~~  :  welcome : " + name);
    }


    // 通过main来模拟注解的使用
    @Autowired
    public static void main(final String[] args) throws Exception {

        TestAnnotation test = new TestAnnotation();
        final ParseMyAnnotation pm = new ParseMyAnnotation();
        pm.parseMethod(test.getClass());
    }

}
