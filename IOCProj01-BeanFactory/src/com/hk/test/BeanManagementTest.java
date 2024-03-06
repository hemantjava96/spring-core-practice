package com.hk.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.hk.beans.WishMessageGenerator;

public class BeanManagementTest {
	// spring 5.0.x doc https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/


	public static void main(String[] args) {
		System.out.println("stat of main(-) method");

		// variables
		WishMessageGenerator generator = null;

		// Locate and hold Spring Bean cfg file
		Resource res = new FileSystemResource("src/com/hk/cfgs/applicationContext.xml");

		// create IOC Container
		BeanFactory factory = new XmlBeanFactory(res);

		// get Bean objs from IOC container
		generator = (WishMessageGenerator) factory.getBean("wmg");
		System.out.println("Wish message::" + generator.sayHello("Hemant"));
		System.out.println("end of main(-) method");
	}
}
