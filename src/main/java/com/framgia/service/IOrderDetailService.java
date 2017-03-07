package com.framgia.service;

import java.util.List;

import com.framgia.bean.OrderDetailInfo;
import com.framgia.bean.ProductInfo;
import com.framgia.bean.UserInfo;

public interface IOrderDetailService extends IBaseService {
	public List<OrderDetailInfo> findByShopId(long shopId);
	
	public boolean saveOrderDetail(List<ProductInfo> productInfoList, long userId);

}
