package com.framgia.dao;

import com.framgia.model.User;

public class UserDAO extends GenericDAO<User, Long> implements IUserDAO {
	public UserDAO() {
		super.setPersistentClass(User.class);
	}

}
