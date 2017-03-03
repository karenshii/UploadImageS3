package com.framgia.dao;

import java.util.List;

import com.framgia.model.OrderDetail;;

public interface IOderDetailDAO extends IGenericDAO<OrderDetail, Long> {
	
	public List<OrderDetail> findByShopId(long shopId);

}
