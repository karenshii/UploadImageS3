package com.framgia.service;

import java.util.List;

import com.framgia.bean.UserInfo;

public interface IUserService extends IBaseService {

	public List<UserInfo> findAll();
	
	public UserInfo findById(int id);

	public void addUser(UserInfo userInfo);
	
	public void editUSer(UserInfo userInfo);

	public void addUser(UserInfo userInfo);

}
