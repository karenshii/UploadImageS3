package com.framgia.service;

import java.util.List;

import com.framgia.bean.UserInfo;

public interface IUserService extends IBaseService {

	public List<UserInfo> findAll();

	public void addUser(UserInfo userInfo);

}
