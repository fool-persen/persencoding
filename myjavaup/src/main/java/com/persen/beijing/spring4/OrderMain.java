package com.persen.beijing.spring4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by persen on 16/10/26.
 */
public class OrderMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring4/orderDemo.xml");
    }

}
