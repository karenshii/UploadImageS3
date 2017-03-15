package com.framgia.service;

import java.util.List;

import com.framgia.bean.CustomerInfo;

public interface ICustomerService extends IBaseService{
	
	List<CustomerInfo> findAllCustomer();
	
	CustomerInfo findCustomerById(int id);
	
	boolean addCustomer(CustomerInfo cusInfo);
	
	boolean editCustomer(CustomerInfo cusInfo);
	
	boolean deleteCustomer(CustomerInfo cusInfo);

}
