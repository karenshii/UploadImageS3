package com.framgia.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.framgia.bean.OrderDetailInfo;
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

}
