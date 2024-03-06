package com.hk.beans;

import java.util.Date;


public class Service {
	private static Service service = new Service();

	private Service() {

	}

	public Date getCurrentDateTime() {
		return new Date();
	}

	public static Service createInstance() {
		return service;
	}

}
