package com.persen.beijing.springmybatis;

import com.persen.beijing.springmybatis.service.ItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMybatis {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ItemService item = (ItemService) context.getBean("itemService");

        item.deal();
    }

}
