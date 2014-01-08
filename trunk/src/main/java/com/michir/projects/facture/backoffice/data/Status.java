package com.michir.projects.facture.backoffice.data;

public class Status {

	private Integer code;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public static Status valueOf(String mesString, Integer code) {
		Status status = new Status();
		status.setMessage(mesString);
		status.setCode(code);
		
		return status;
	}
	
}
