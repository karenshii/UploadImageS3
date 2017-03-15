package com.framgia.service;

import com.framgia.dao.ICustomerDAO;
import com.framgia.dao.IOderDetailDAO;
import com.framgia.dao.IOrderDAO;
import com.framgia.dao.IProductDAO;
import com.framgia.dao.IShopDAO;
import com.framgia.dao.IUserDAO;;

public class BaseService implements IBaseService {

	protected IUserDAO userDAO;
	
	protected IShopDAO shopDAO;
	
	protected IProductDAO productDAO;
	protected IOrderDAO orderDAO;
	

	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	protected ICustomerDAO customerDAO;

	public ICustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public IProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(IProductDAO productDAO) {
		this.productDAO = productDAO;
	}

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
