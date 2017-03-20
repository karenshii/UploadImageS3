package com.framgia.model;

import java.util.Date;

public class Product {
	private Long id;
	private String name;
	private String detail;
	private double price;
	private String image;
	private Date date;
	private int status;
	private Long shopId;

	public Product() {
	}
	
	

	public Product(long id, String name, String detail, double price, String image, Date date, int status,
			long shopId) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.price = price;
		this.image = image;
		this.date = date;
		this.status = status;
		this.shopId = shopId;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

}
