package com.framgia.service;

import com.framgia.dao.IShopDAO;
import com.framgia.dao.IUserDAO;
import com.framgia.dao.IOderDetailDAO;;

public class BaseService implements IBaseService {

	protected IUserDAO userDAO;
	
	protected IShopDAO shopDAO;

	public IUserDAO getUserDAO() {
		return this.userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	protected IOderDetailDAO orderDetailDAO;

	public IShopDAO getShopDAO() {
		return shopDAO;
	}

	public void setShopDAO(IShopDAO shopDAO) {
		this.shopDAO = shopDAO;
	}
  
	public IOderDetailDAO getOrderDetailDAO() {
		return orderDetailDAO;
	}

	public void setOrderDetailDAO(IOderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}

}
