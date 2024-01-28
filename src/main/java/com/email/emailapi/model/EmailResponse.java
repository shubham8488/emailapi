package com.email.emailapi.model;

public class EmailResponse {
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EmailResponse [message=" + message + "]";
	}

	public EmailResponse(String message) {
		super();
		this.message = message;
	}

	public EmailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
