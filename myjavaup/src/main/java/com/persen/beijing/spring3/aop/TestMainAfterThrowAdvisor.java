package com.persen.beijing.spring3.aop;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainAfterThrowAdvisor {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        SumService ss = (SumService) context.getBean("sumService");
        //
        try {

            ss.doSumOther();
        } catch (SQLException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        ss.doSum();
    }

}
