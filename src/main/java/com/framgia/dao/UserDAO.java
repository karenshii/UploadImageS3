package com.framgia.dao;

import com.framgia.model.User;

public class UserDAO extends GenericDAO<User, Integer> implements IUserDAO {
	public UserDAO() {
		super(User.class);
	}

}
