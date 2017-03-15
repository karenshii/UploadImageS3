package com.framgia.dao;

import com.framgia.model.Customer;

public class CustomerDAO extends GenericDAO<Customer, Integer> implements ICustomerDAO{
	
	public CustomerDAO() {
		super(Customer.class);
	}

}
