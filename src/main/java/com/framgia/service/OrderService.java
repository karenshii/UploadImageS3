package com.framgia.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.framgia.bean.ProductInfo;
import com.framgia.model.Order;

public class OrderService extends BaseService implements IOderService {

	private static final Logger logger = Logger.getLogger(IOderService.class);

	public long saveOrder(List<ProductInfo> productInfoList, long userId) {		
		if (productInfoList!=null) {
			double totalMoney = 0.0;
			for (ProductInfo productInfo : productInfoList) {
				totalMoney = totalMoney + productInfo.getPrice() * productInfo.getQuantity();
			}
			Order order = new Order();
			order.setCustomerId(userId);
			order.setTotalMoney(totalMoney);
			Date date = new Date();
			order.setDate(date);
			order.setStatus(0);
			try {
				orderDAO.save(order);
				return order.getId();

			} catch (Exception e) {
				logger.error(e);
				return 0;
			}			
		}
		return 0;
		
	}

}
