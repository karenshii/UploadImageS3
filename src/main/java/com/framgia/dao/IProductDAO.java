package com.framgia.dao;

import java.util.List;

import com.framgia.model.OrderDetail;
import com.framgia.model.Product;



public interface IProductDAO extends IGenericDAO<Product, Long> {
	
	public List<Product> findByShopId(long shopId);

}
