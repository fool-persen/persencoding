package com.persen.beijing.spring.InitializingBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "TestInitializingBean.xml");
        System.out.println("----");
    }

}
