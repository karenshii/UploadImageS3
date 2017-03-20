package com.framgia.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.framgia.model.Product;

public class ProductInfo {
	private Long id;
	private String name;
	private String detail;
	private double price;
	private CommonsMultipartFile fileData;
	private String image;
	private Date date;
	private int status;
	private Long shopId;
	private int quantity;
	
	
	
	public CommonsMultipartFile getFileData() {
		return fileData;
	}
	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public ProductInfo() {
		super();
	}
	public ProductInfo(long shopId) {
		super();
		this.shopId = shopId;
	}
	
	public List<ProductInfo> copy(List<Product> productList) {
		List<ProductInfo> productInfos = new ArrayList<ProductInfo>();
		if (productList == null)
			return productInfos;
		for (Product product : productList) {
			ProductInfo productInfo = new ProductInfo();
			BeanUtils.copyProperties(product, productInfo);
			productInfos.add(productInfo);
		}
		return productInfos;
	}
}
