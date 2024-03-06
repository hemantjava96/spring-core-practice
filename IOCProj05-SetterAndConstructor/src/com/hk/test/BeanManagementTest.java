package com.hk.test;

import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.hk.beans.WishMessageGenerator;

public class BeanManagementTest {

	// spring 5.0.x doc
	// https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/

	public static void main(String[] args) {
		System.out.println("stat of main(-) method");

		// Declare the ApplicationContext reference outside the try block to ensure its accessibility in the finally block.
		ApplicationContext applicationContext = null;
		try {
			applicationContext = new ClassPathXmlApplicationContext("com/hk/cfgs/applicationContext.xml");

			WishMessageGenerator wmg = applicationContext.getBean("wmg", WishMessageGenerator.class);

			System.out.println(wmg.sayHello());

		} finally {
			// Close the applicationContext in the finally block to ensure it gets closed regardless of exceptions.
			if (applicationContext != null) {
				((ClassPathXmlApplicationContext) applicationContext).close();
			}
		}

		System.out.println("end of main(-) method");
	}

}
