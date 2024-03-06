//Spring Bean class (POJO class)
package com.hk.beans;

import java.util.Date;

public class WishMessageGenerator {

	private Date date;

	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator.0-param constructor");
	}

	public String sayHello(String user) {
		return "Hello " + user + ", The time is::" + date.toString();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
