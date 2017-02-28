package com.framgia.model;
// Generated Feb 27, 2017 3:44:10 PM by Hibernate Tools 5.2.0.CR1

import java.util.Date;

/**
 * Order generated by hbm2java
 */
public class Order implements java.io.Serializable {

	private Integer id;
	private Customer customer;
	private Double totalmoney;
	private Date date;
	private Integer status;
	private OrderDetail orderDetail;

	public Order() {
	}

	public Order(Customer customer) {
		this.customer = customer;
	}

	public Order(Customer customer, Double totalmoney, Date date, Integer status, OrderDetail orderDetail) {
		this.customer = customer;
		this.totalmoney = totalmoney;
		this.date = date;
		this.status = status;
		this.orderDetail = orderDetail;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getTotalmoney() {
		return this.totalmoney;
	}

	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public OrderDetail getOrderDetail() {
		return this.orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

}