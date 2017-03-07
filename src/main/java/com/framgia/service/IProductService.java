package com.framgia.service;

import java.util.List;

import com.framgia.bean.ProductInfo;


public interface IProductService extends IBaseService {
	public List<ProductInfo> findByShopId(long shopId);
	public void addProduct(ProductInfo productInfo);
	public ProductInfo findById(long id) ;
	public void editProduct(ProductInfo productInfo);

}
