package com.hk.test;

import java.util.Date;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.hk.beans.WishMessageGenerator;

public class BeanManagementTest {
	
	// spring 5.0.x doc https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/

	public static void main(String[] args) {
		System.out.println("stat of main(-) method");
		
//		//ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/hk/cfgs/applicationContext.xml");
//		Date date = applicationContext.getBean("dt", Date.class);
//		WishMessageGenerator wmg = applicationContext.getBean("wmg",WishMessageGenerator.class);	
		
		
		GenericApplicationContext context = new GenericApplicationContext();
		new XmlBeanDefinitionReader(context).loadBeanDefinitions("com/hk/cfgs/applicationContext.xml");
		//new XmlBeanDefinitionReader(context).loadBeanDefinitions("services.xml", "daos.xml");
		context.refresh();
		Date date = context.getBean("dt", Date.class);
		WishMessageGenerator wmg = context.getBean("wmg",WishMessageGenerator.class);
		
		
		System.out.println(wmg.sayHello("Hemant"));
		System.out.println("date : " +date);

		System.out.println("end of main(-) method");
	}
}
