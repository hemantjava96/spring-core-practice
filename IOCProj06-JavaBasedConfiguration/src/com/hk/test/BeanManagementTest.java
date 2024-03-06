package com.hk.test;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hk.beans.MessageService;
import com.hk.beans.Service;
import com.hk.beans.WishMessageGenerator;

public class BeanManagementTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		System.out.println("Start of main method");

		// Create the Spring application context with the configuration class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.hk.cfgs");

		// Retrieve the bean from the context
		WishMessageGenerator wmg = context.getBean("wmg", WishMessageGenerator.class);
		System.out.println("Message: " + wmg.sayHello());

		// Static Factory Method
		System.out.println("...........................................");
		Service service = context.getBean("service", Service.class);
		System.out.println(service.getCurrentDateTime());

		// Instance Factory Method
		System.out.println("...........................................");
		MessageService messageService = context.getBean("messageService", MessageService.class);
		System.out.println(messageService.getMessage());

		// Static and Instance Factory methods with arguments
		System.out.println("...........................................");
		Class c1 = context.getBean("c1", Class.class);
		System.out.println("c1 obj class: " + c1.getClass() + " c1 obj data::" + c1);
		Date dt = (Date) c1.newInstance();
		System.out.println(dt);

		System.out.println("...........................................");
		Calendar cal = context.getBean("cal", Calendar.class);
		System.out.println("cal obj calss name:" + cal.getClass() + " cal obj data::" + cal);

		System.out.println("..............................................");
		String s2 = context.getBean("s2", String.class);
		System.out.println("s2 obj class :" + s2.getClass() + " s2 obj data::" + s2);

		System.out.println("........................................");
		String s4 = context.getBean("s4", String.class);
		System.out.println("s4 obj class :" + s4.getClass() + " s4 obj data::" + s4);

		// Close the context
		context.close();

		System.out.println("End of main method");
	}
}
