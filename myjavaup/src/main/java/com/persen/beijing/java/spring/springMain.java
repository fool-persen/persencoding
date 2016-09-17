package com.persen.beijing.java.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "spring.xml");
        System.out.println("---------");
        UserDao ud = (UserDao) context.getBean("userDao");
    }

}
