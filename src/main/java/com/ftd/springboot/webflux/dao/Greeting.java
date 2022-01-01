package com.ftd.springboot.webflux.dao;

public class Greeting {
	
	public Greeting() {
		super();
	}

	private String message;

	@Override
	public String toString() {
		return "Greeting [message=" + message + "]";
	}

	public Greeting(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
