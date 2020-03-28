package com.persen.beijing.spring3.LifeCycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by lijy on 2017/10/27.
 */
public class BeanLifeCycle {

	private static void LifeCycleInBeanFactory() {

		ClassPathXmlApplicationContext bf = new ClassPathXmlApplicationContext("/spring3/lifeCycle.xml");

		//BeanFactory 生命周期
		/*
		Resource res = new ClassPathResource("/spring3/lifeCycle.xml");
//		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:/spring3/lifeCycle.xml").getBeanFactory();
		BeanFactory bf = new XmlBeanFactory(res);
		((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());
		((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		*/

		System.out.println("getBean persen1 begin");
		Person person1 = (Person) bf.getBean("person");
		System.out.println("getBean persen1 end");
		System.out.println("getBean persen2 begin");
		Person person2 = (Person) bf.getBean("person");
		System.out.println("getBean persen2 end");

		System.out.println("persen1==persen2" + (person1 == person2));
//		((ConfigurableBeanFactory) bf).destroySingletons();
		((ClassPathXmlApplicationContext)bf).registerShutdownHook();
	}

	public static void main(String[] args) {
		LifeCycleInBeanFactory();
	}
}
