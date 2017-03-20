package com.framgia.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.framgia.bean.ProductInfo;

public interface IProductService extends IBaseService {
	public List<ProductInfo> findByShopId(long shopId);

	public Long addProduct(ProductInfo productInfo);

	public ProductInfo findById(long id);

	public boolean editProduct(ProductInfo productInfo);

	public List<ProductInfo> getAll();

	public String getImage(Long productId);

	public String upToS3(CommonsMultipartFile imageFile, Long productId);

	public boolean editImage(Long productId, String newImage);
}
