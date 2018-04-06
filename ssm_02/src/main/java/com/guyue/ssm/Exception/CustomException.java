package com.guyue.ssm.Exception;

public class CustomException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomException(String message) {
		this.message = message;
	}
}
