package com.hk.test;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hk.beans.MessageService;
import com.hk.beans.Service;

public class BeanManagementTest {

	// spring 5.0.x doc
	// https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		System.out.println("stat of main(-) method");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/hk/cfgs/applicationContext.xml");

		// Static Factory Method
		System.out.println("...........................................");
		Service service = applicationContext.getBean("service", Service.class);
		System.out.println(service.getCurrentDateTime());
		
		//Instance Factory Method
		System.out.println("...........................................");
		MessageService messageService = applicationContext.getBean("messageService", MessageService.class);
		System.out.println(messageService.getMessage());
		
		//Static and Instance Factory methods with arguments
		System.out.println("...........................................");
		Class c1=applicationContext.getBean("c1",Class.class);
		System.out.println("c1 obj class: "+c1.getClass()+" c1 obj data::"+c1);
		Date dt = (Date)c1.newInstance();
		System.out.println(dt);
		
		System.out.println("...........................................");
		Calendar cal =applicationContext.getBean("cal",Calendar.class);
		System.out.println("cal obj calss name:"+cal.getClass()+" cal obj data::"+cal);
		
		System.out.println("..............................................");
		String s2=applicationContext.getBean("s2",String.class);
		System.out.println("s2 obj class :"+s2.getClass()+" s2 obj data::"+s2);
		
		System.out.println("........................................");
		String s4=applicationContext.getBean("s4",String.class);
		System.out.println("s4 obj class :"+s4.getClass()+" s4 obj data::"+s4);

		System.out.println("end of main(-) method");
	}
}
