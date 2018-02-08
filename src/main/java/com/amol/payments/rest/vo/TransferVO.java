package com.amol.payments.rest.vo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Amol Waghmare
 *
 *         Value object class which is java representation of the Account
 *         information in JSON/XML format
 */

@XmlRootElement
public class TransferVO {
	
	private int transferNumber;

	public int getTransferNumber() {
		return transferNumber;
	}

	public void setTransferNumber(int transferNumber) {
		this.transferNumber = transferNumber;
	}

	private int fromAccountnumber;

	private int toAccountnumber;

	private double transferAmount;

	public int getFromAccountnumber() {
		return fromAccountnumber;
	}

	public void setFromAccountnumber(int fromAccountnumber) {
		this.fromAccountnumber = fromAccountnumber;
	}

	public int getToAccountnumber() {
		return toAccountnumber;
	}

	public void setToAccountnumber(int toAccountnumber) {
		this.toAccountnumber = toAccountnumber;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	
}
