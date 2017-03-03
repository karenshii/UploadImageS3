package com.framgia.service;

import java.util.List;

import com.framgia.bean.OrderDetailInfo;

public interface IOrderDetailService extends IBaseService {
	public List<OrderDetailInfo> findByShopId(long shopId);

}
