//Spring Bean class (POJO class)
package com.hk.beans;

import java.util.Date;


public class WishMessageGenerator {

	private String message;
	private String user;

	private Date date;

	public WishMessageGenerator(String message) {
		System.out.println("WishMessageGenerator.WishMessageGenerator(-)");
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		System.out.println("WishMessageGenerator.setMessage(-)");
		this.message = message;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		System.out.println("WishMessageGenerator.setUser(-)");
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		System.out.println("WishMessageGenerator.setDate()");
		this.date = date;
	}

	public String sayHello() {
		return getMessage() + getUser() + ". Time is : " + getDate();
	}
}
