package com.amol.payments.data.entity;

import java.io.Serializable;

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
@Table(name="ACCOUNT")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	public Account() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountnumber;
	
	private String name;
	
	private double balance;

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
