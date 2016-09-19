package com.persen.beijing.springmybatis;

import com.persen.beijing.springmybatis.service.impl.AddUpServiceImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSession {

    public static void main(String[] args) {

        System.out.println(System.getProperty("java.class.path"));//系统的classpaht路径
        System.out.println(System.getProperty("user.dir"));//用户的当前路径

        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                "TestSession.xml");
        AddUpServiceImpl ad = (AddUpServiceImpl) context.getBean("AddUpServiceImpl");

        ad.process();
        context.close();
    }

}
