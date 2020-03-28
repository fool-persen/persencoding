package com.persen.beijing.springBoot.beanConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lijy on 2018/2/6.
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
		System.out.println(useFunctionService.sayHello("java.config"));

		context.close();
	}
}
