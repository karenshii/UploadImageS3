package com.framgia.service;

import com.framgia.dao.IUserDAO;
import com.framgia.dao.IOderDetailDAO;;

public class BaseService implements IBaseService {

	protected IUserDAO userDAO;

	public IUserDAO getUserDAO() {
		return null;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	protected IOderDetailDAO orderDetailDAO;

	public IOderDetailDAO getOrderDetailDAO() {
		return orderDetailDAO;
	}

	public void setOrderDetailDAO(IOderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}
	
	
	
}
