package com.hk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hk.beans.WishMessageGenerator;

public class BeanManagementTest {
	
	// spring 5.0.x doc https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/

	public static void main(String[] args) {
		System.out.println("stat of main(-) method");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/hk/cfgs/applicationContext.xml");
		
		WishMessageGenerator wmg = applicationContext.getBean("wmg",WishMessageGenerator.class);
		
		System.out.println(wmg.sayHello("Hemant"));

		System.out.println("end of main(-) method");
	}
}
