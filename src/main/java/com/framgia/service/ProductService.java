package com.framgia.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.framgia.bean.ProductInfo;
import com.framgia.bean.ShopInfo;
import com.framgia.bean.UserInfo;
import com.framgia.model.Product;
import com.framgia.model.Shop;
import com.framgia.model.User;

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

	public boolean addProduct(ProductInfo productInfo) {
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
			return false;
		}
		return true;
	}

	public ProductInfo findById(long id) {
		try {
			Product product = productDAO.findById(id);
			ProductInfo productInfo = new ProductInfo();
			BeanUtils.copyProperties(product, productInfo);
			return productInfo;
		} catch (Exception e) {
			logger.error("An exception when find product by id: " + e);
		}
		return null;
	}

	public boolean editProduct(ProductInfo productInfo) {
		try {
			Product product = new Product();
			BeanUtils.copyProperties(productInfo, product);
			Date date = new Date();
			product.setDate(date);
			Product result = productDAO.save(product);
			logger.debug("save successful product :" + result);
		} catch (Exception e) {
			logger.error("An exception save product: " + e);
			return false;
		}
		return true;
	}

}
