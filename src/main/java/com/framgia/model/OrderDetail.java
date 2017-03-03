package com.framgia.model;

/* 
 * Edit by tungtv
 * */
public class OrderDetail {

	private Long id;
	private int quantity;
	private Long productId;
	private int status;
	private Long shopId;

	public OrderDetail() {
	}

	public OrderDetail(Long id, int quantity, Long productId, int status, Long shopId) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.productId = productId;
		this.status = status;
		this.shopId = shopId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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
