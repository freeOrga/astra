package com.younes.app.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Error {
	String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	String message;
}
