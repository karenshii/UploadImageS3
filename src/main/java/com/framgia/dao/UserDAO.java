package com.framgia.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.framgia.model.User;

public class UserDAO extends GenericDAO<User, Integer> implements IUserDAO {
	public UserDAO() {
		super(User.class);
	}
	
	@Override
	public User findByUserName(String username) {
		User user = new User();
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		user = (User) criteria.add(Restrictions.eq("username", username)).uniqueResult();
		return user;
	}

}
