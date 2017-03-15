package com.framgia.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.framgia.model.Order;
/**
 * @author toandk
 */
public class CustomerInfo {
	
	private Integer id;
	private String name;
	private Date dob;
	private String address;
	private String tel;
	private String email;
	
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CustomerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerInfo(Integer id, String name, Date dob, String address, String tel, String email) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.tel = tel;
		this.email = email;
	}
	
	

}
