package com.hk.beans;

public class InstanceFactory {
	//One factory class can also hold more than one factory method
	private static MessageService messageService = new MessageService();
	
	
	public MessageService getMessageService() {
		return messageService;
	}

}
