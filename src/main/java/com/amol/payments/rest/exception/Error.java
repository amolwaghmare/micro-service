package com.amol.payments.rest.exception;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Amol Waghmare
 *
 */

@XmlRootElement
public class Error {
	
	private String code;
	
	private String message;
	
	private int severity;

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

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

}
