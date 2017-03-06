package com.framgia.service;

import java.util.List;

import com.framgia.bean.ProductInfo;


public interface IProductService extends IBaseService {
	public List<ProductInfo> findByShopId(long shopId);

}
