package com.framgia.service;

import com.framgia.dao.IUserDAO;

public class BaseService implements IBaseService {

	protected IUserDAO userDAO;

	public IUserDAO getUserDAO() {
		return null;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
