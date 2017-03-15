package com.framgia.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.framgia.bean.CustomerInfo;
import com.framgia.model.Customer;
import com.framgia.util.Helpers;

public class CustomerService extends BaseService implements ICustomerService {

	public static final Logger logger = Logger.getLogger(CustomerService.class);

	@Override
	public List<CustomerInfo> findAllCustomer() {
		try {
			List<Customer> listCus = customerDAO.findAll();
			if (!Helpers.isEmpty(listCus)) {
				List<CustomerInfo> listCusInfo = new ArrayList<CustomerInfo>();
				for (Customer cus : listCus) {
					CustomerInfo cusInfo = new CustomerInfo();
					BeanUtils.copyProperties(cus, cusInfo);
					listCusInfo.add(cusInfo);
				}
				logger.debug("find all customer:" + listCusInfo);
				return listCusInfo;
			}
		} catch (Exception e) {
			logger.error("An exception:" + e);
		}
		return null;
	}

	@Override
	public CustomerInfo findCustomerById(int id) {
		try {
			Customer cus = customerDAO.findById(new Integer(id));
			if (cus != null) {
				CustomerInfo cusInfo = new CustomerInfo();
				cusInfo.setAddress(cus.getAddress());
				cusInfo.setDob(cus.getDob());
				cusInfo.setEmail(cus.getEmail());
				cusInfo.setId(cus.getId());
				cusInfo.setName(cus.getName());
				cusInfo.setTel(cus.getTel());

				logger.debug("get Customer by id:" + cusInfo);
				return cusInfo;
			}
		} catch (Exception e) {
			logger.error("An exception:" + e);
		}
		return null;
	}

	@Override
	public boolean addCustomer(CustomerInfo cusInfo) {
		try {
			Customer obj = new Customer();
			obj.setAddress(cusInfo.getAddress());
			obj.setDob(cusInfo.getDob());
			obj.setEmail(cusInfo.getEmail());
			obj.setId(cusInfo.getId());
			obj.setName(cusInfo.getName());
			obj.setTel(cusInfo.getTel());

			obj = customerDAO.save(obj);
			logger.debug("save successful:" + obj);
			return true;
		} catch (Exception e) {
			logger.error("An exception:" + e);
		}
		return false;
	}

	@Override
	public boolean editCustomer(CustomerInfo cusInfo) {
		try {
			Customer obj = new Customer();
			obj.setAddress(cusInfo.getAddress());
			obj.setDob(cusInfo.getDob());
			obj.setEmail(cusInfo.getEmail());
			obj.setId(cusInfo.getId());
			obj.setName(cusInfo.getName());
			obj.setTel(cusInfo.getTel());

			obj = customerDAO.save(obj);
			logger.debug("edit successful:" + obj);
			return true;
		} catch (Exception e) {
			logger.error("An exception:" + e);
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(CustomerInfo cusInfo) {
		try {
			Customer obj = new Customer();
			obj = customerDAO.findById(cusInfo.getId());
			if(obj != null){
				customerDAO.delete(obj);
				logger.debug("delete successful:" + cusInfo);
				return true;
			}
		} catch (Exception e) {
			logger.error("An exception:" + e);
		}
		return false;
	}

}
