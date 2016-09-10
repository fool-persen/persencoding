package com.persen.beijing.java.springmybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.persen.beijing.java.springmybatis.service.ItemService;

public class TestSpringMybatis {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ItemService item = (ItemService) context.getBean("itemService");
		
		item.deal();
	}

}
