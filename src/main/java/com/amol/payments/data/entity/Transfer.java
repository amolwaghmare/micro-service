package com.amol.payments.data.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Amol Waghmare
 *
 */
@Entity 
@Table(name="TRANSFER")
public class Transfer {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int fromAccountnumber;
	
	private int toAccountnumber;
	
	private double transferAmount;

	private Date transferDate;
	
	public Transfer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	
	
}
