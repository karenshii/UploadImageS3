package com.framgia.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ShopInfo {
	
	private Integer id;
	private String name;
	private String address;
	private String tel;
	private List<OrderDetailInfo> orderDetailsInfo = new ArrayList<OrderDetailInfo>();
	private List<UserInfo> usersInfo = new ArrayList<UserInfo>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<OrderDetailInfo> getOrderDetailsInfo() {
		return orderDetailsInfo;
	}
	public void setOrderDetailsInfo(List<OrderDetailInfo> orderDetailsInfo) {
		this.orderDetailsInfo = orderDetailsInfo;
	}
	public List<UserInfo> getUsersInfo() {
		return usersInfo;
	}
	public void setUsersInfo(List<UserInfo> usersInfo) {
		this.usersInfo = usersInfo;
	}
	public ShopInfo(Integer id, String name, String address, String tel, List<OrderDetailInfo> orderDetailsInfo,
			List<UserInfo> usersInfo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.orderDetailsInfo = orderDetailsInfo;
		this.usersInfo = usersInfo;
	}
	public ShopInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
