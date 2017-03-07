package com.framgia.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.framgia.bean.ProductInfo;
import com.framgia.model.Product;


public class ProductService extends BaseService implements IProductService {

	private static final Logger logger = Logger.getLogger(OrderDetailService.class);

	public List<ProductInfo> findByShopId(long shopId) {
		try {
			List<Product> productList = productDAO.findByShopId(shopId);
			List<ProductInfo> productInfoList = new ArrayList<ProductInfo>();
			
			for (Product product : productList) {
				ProductInfo productInfo = new ProductInfo();
				BeanUtils.copyProperties(product, productInfo);
				productInfoList.add(productInfo);
			}
			return productInfoList;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
	
	public void addProduct(ProductInfo productInfo) {
		logger.debug("persisting user instance");
		try {
			Product product = new Product();
			product.setName(productInfo.getName());
			product.setDetail(productInfo.getDetail());
			product.setPrice(productInfo.getPrice());
			product.setImage(productInfo.getImage());
			Date date = new Date();
			product.setDate(date);
			product.setStatus(productInfo.getStatus());
			product.setShopId(productInfo.getShopId());
			Product result = productDAO.save(product);
			logger.debug("save successful user :" + result);
		} catch (Exception e) {
			logger.error("An exception save user: " + e);
		}

		
	}

}
