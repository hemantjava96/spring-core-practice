package com.hk.cfgs;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hk.beans.InstanceFactory;
import com.hk.beans.MessageService;
import com.hk.beans.Service;
import com.hk.beans.WishMessageGenerator;

@Configuration
public class ApplicationContextBeanConfiguration {

	@Bean(name = "date")
	public Date date() {
		return new Date();
	}

	@Bean(name = "wmg")
	public WishMessageGenerator wishMessageGenerator() {
		WishMessageGenerator wmg = new WishMessageGenerator("Good Morning...!");//constructor injection
		wmg.setUser("hemant");
		wmg.setDate(date()); // setter injection
		return wmg;
	}

	@Bean
	public Service service() {
		return Service.createInstance();//static factory method injection
	}

	@Bean
	public InstanceFactory instanceFactory() {
		return new InstanceFactory();
	}

	@Bean
	public MessageService messageService(InstanceFactory instanceFactory) {
		return instanceFactory.getMessageService();//instance factory method injection
	}

	@Bean
	public Class<?> c1() throws ClassNotFoundException {
		return Class.forName("java.util.Date");
	}

	@Bean
	public Calendar cal() {
		return Calendar.getInstance();
	}

	@Bean
	public String s1() {
		return new String("hello");
	}

	@Bean
	public String s2(String s1) {
		return s1.concat(" Dear");
	}

	@Bean
	public StringBuffer s3() {
		return new StringBuffer("hello how are u?");
	}

	@Bean
	public String s4(StringBuffer s3) {
		return s3.substring(0, 5);
	}
}