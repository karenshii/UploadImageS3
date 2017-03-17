package com.framgia.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.framgia.bean.OrderDetailInfo;
import com.framgia.bean.ProductInfo;
import com.framgia.model.Order;
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

	public boolean saveOrderDetail(List<ProductInfo> productInfoList, long orderNum) {
		for (ProductInfo productInfo : productInfoList) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderNum(orderNum);
			orderDetail.setProductId(productInfo.getId());
			orderDetail.setQuantity(productInfo.getQuantity());
			orderDetail.setStatus(0);
			orderDetail.setShopId(productInfo.getShopId());
			try {
				orderDetailDAO.save(orderDetail);
			} catch (Exception e) {
				logger.error(e);
				return false;
			}
		}
		return true;
	}

	public boolean editStatusOrderDetail(long orderDetailId) {
		try {
			OrderDetail orderDetail = orderDetailDAO.findById(orderDetailId);
			long orderNum = orderDetailDAO.editStatusOrderDetail(orderDetail);
			Order order = orderDAO.findById(orderNum);
			int totalStatus = orderDetailDAO.totalStatus(orderNum);
			order.setStatus(totalStatus);
			orderDAO.save(order);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}

	}



}
