package com.amol.payments.rest.exception;

/**
 *  @author Amol
 */
public class PaymentsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public  PaymentsException(String message) {
		super(message);
		System.out.println("payments exception: "+message);
		
	}

}
