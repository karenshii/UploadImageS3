package com.framgia.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.framgia.bean.OrderDetailInfo;
import com.framgia.model.OrderDetail;

public class OrderDetailService extends BaseService implements IOrderDetailService {

	private static final Logger logger = Logger.getLogger(OrderDetailService.class);

	public List<OrderDetailInfo> findByShopId(long shopId) {
		try {
			List<OrderDetail> orderDetailList = orderDetailDAO.findByShopId(shopId);
			List<OrderDetailInfo> orderDetailInfoList = new ArrayList<OrderDetailInfo>();
			
			for (OrderDetail orderDetail : orderDetailList) {
				OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
				BeanUtils.copyProperties(orderDetail, orderDetailInfo);
				orderDetailInfoList.add(orderDetailInfo);
			}
			return orderDetailInfoList;
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

}
