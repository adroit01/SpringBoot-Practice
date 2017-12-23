package com.adroit.rest.webservices.restdemo.helloworld;

import org.springframework.context.annotation.Bean;


public class HelloWorldBean {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorldBean(String msg)
	{
		this.message = msg;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
}
