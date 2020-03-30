package com.persen.beijing.SpringConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lijy on 2017/10/24.
 */
public class SpringTest {
	public static void main(String[] args) {
		//xml的扫描表中扫面 @Configuration
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringConfig/beans.xml");// 读取bean.xml中的内容
		//指定包下查找 @Configuration
//		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.persen.beijing.SpringConfig");
		//通过配置类的class对象启动
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

		Counter c = ctx.getBean("counter", Counter.class);// 创建bean的引用对象
		System.out.println(c.getMultiplier());
		System.out.println(c.getSong());
	}
}
