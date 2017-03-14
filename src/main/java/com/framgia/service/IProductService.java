package com.framgia.service;

import java.util.List;

import com.framgia.bean.ProductInfo;


public interface IProductService extends IBaseService {
	public List<ProductInfo> findByShopId(long shopId);
	public boolean addProduct(ProductInfo productInfo);
	public ProductInfo findById(long id) ;
	public boolean editProduct(ProductInfo productInfo);

}
