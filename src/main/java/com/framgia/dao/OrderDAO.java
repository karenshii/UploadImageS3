package com.framgia.dao;


import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.framgia.model.Order;

public class OrderDAO extends GenericDAO<Order, Long> implements IOrderDAO {
	public OrderDAO() {
		super(Order.class);
	}



}