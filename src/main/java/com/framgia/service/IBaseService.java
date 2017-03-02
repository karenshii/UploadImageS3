package com.framgia.service;

import java.io.Serializable;

import com.framgia.dao.IShopDAO;
import com.framgia.dao.IUserDAO;

public interface IBaseService extends Serializable {
	
	IUserDAO getUserDAO();
	
	IShopDAO getShopDAO();
}
