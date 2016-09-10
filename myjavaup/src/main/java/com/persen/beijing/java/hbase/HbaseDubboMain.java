package com.persen.beijing.java.hbase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HbaseDubboMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "HbaseDubbo.xml" });

		//GetBillService service = context.getBean("GetBillService");
	}

}
