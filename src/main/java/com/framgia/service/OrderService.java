package com.framgia.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.framgia.bean.ProductInfo;
import com.framgia.model.Order;
import com.framgia.model.OrderDetail;

public class OrderService extends BaseService implements IOderService {
	
	public static final int NO_CONFIRM = 0;

	private static final Logger logger = Logger.getLogger(IOderService.class);

	public boolean saveOrder(List<ProductInfo> productInfoList, long userId) {
		if (productInfoList != null) {
			double totalMoney = 0.0;
			for (ProductInfo productInfo : productInfoList) {
				totalMoney = totalMoney + productInfo.getPrice() * productInfo.getQuantity();
			}
			Order order = new Order();
			order.setCustomerId(userId);
			order.setTotalMoney(totalMoney);
			Date date = new Date();
			order.setDate(date);
			order.setStatus(NO_CONFIRM);
			try {
				orderDAO.save(order);
				long orderNum = order.getId();
				for (ProductInfo productInfo : productInfoList) {
					OrderDetail orderDetail = new OrderDetail();
					orderDetail.setOrderNum(orderNum);
					orderDetail.setProductId(productInfo.getId());
					orderDetail.setQuantity(productInfo.getQuantity());
					orderDetail.setStatus(NO_CONFIRM);
					orderDetail.setShopId(productInfo.getShopId());
					try {
						orderDetailDAO.save(orderDetail);
					} catch (Exception e) {
						logger.error(e);
					}
				}
			} catch (Exception e) {
				logger.error(e);
				return false;
			}

		}
		return true;
	}

}
