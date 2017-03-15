package com.framgia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FRAMGIA\do.khanh.toan
 */
public class User implements java.io.Serializable {

	private Integer id;
	private Shop shop;
	private String username;
	private String password;
	private Integer role;
	private Integer status;
	private List<UserRole> userRoles = new ArrayList<UserRole>();

	public User() {
	}

	public User(Integer id, Shop shop) {
		this.id = id;
		this.shop = shop;
	}

	public User(Integer id, Shop shop, String username, String password, Integer role, Integer status) {
		this.id = id;
		this.shop = shop;
		this.username = username;
		this.password = password;
		this.role = role;
		this.status = status;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
