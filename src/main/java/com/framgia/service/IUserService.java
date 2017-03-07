package com.framgia.service;

import java.util.List;

import com.framgia.bean.UserInfo;

public interface IUserService extends IBaseService {

	public List<UserInfo> findAll();
	
	public UserInfo findById(int id);

	
	public boolean editUSer(UserInfo userInfo);

	public boolean addUser(UserInfo userInfo);
	
	public boolean deleteuser(UserInfo userInfo);

}
