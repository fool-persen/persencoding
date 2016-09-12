package com.persen.beijing.spEl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by persen on 16/9/12.
 */
public class App {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("/spEl/Spring-EL.xml");

        Customer obj = (Customer) context.getBean("customerBean");
        System.out.println(obj);

    }
}
