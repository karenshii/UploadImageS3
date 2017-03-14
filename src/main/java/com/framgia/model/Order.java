package com.framgia.model;

import java.util.Date;

public class Order {

	private long id;
	private double totalMoney;
	private Date date;
	private int status;
	private long customerId;

	public Order() {
	}
	

	public Order(long id, double totalMoney, Date date, int status, long customerId) {
		super();
		this.id = id;
		this.totalMoney = totalMoney;
		this.date = date;
		this.status = status;
		this.customerId = customerId;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	

	

}
