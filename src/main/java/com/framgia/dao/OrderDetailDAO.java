package com.framgia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.framgia.model.OrderDetail;

public class OrderDetailDAO extends GenericDAO<OrderDetail, Long> implements IOderDetailDAO {

	public static final int CONFIRM = 1;
	public static final int NO_CONFIRM = 0;
	public static final int ERROR_CODE = -1;

	public OrderDetailDAO() {
		super(OrderDetail.class);
	}

	public List<OrderDetail> findByShopId(long shopId) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Restrictions.eq("shopId", shopId));
		Object obj = criteria.list();
		if (obj == null) {
			return null;
		}
		return (List<OrderDetail>) obj;
	}

	public long editStatusOrderDetail(OrderDetail orderDetail) {
		if (orderDetail == null)
			return ERROR_CODE;
		if (orderDetail.getStatus() == NO_CONFIRM)
			orderDetail.setStatus(CONFIRM);
		else {
			orderDetail.setStatus(NO_CONFIRM);
		}
		try {
			save(orderDetail);
		} catch (Exception e) {
			return ERROR_CODE;
		}
		return orderDetail.getOrderNum();
	}

	public int totalStatus(long orderId) {
		try {
			String sql = "select sum(o.status) from " + OrderDetail.class.getName() + " o " + " where o.orderNum= :orderId";
			Query query = getSession().createQuery(sql);
			query.setParameter("orderId", orderId);
			int totalStatus = Integer.parseInt(query.uniqueResult().toString());
			return totalStatus;
		} catch (Exception e) {
			return ERROR_CODE;
		}
		
	}

	public List<OrderDetail> findByOrderId(long orderId) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Restrictions.eq("orderNum", orderId));
		Object obj = criteria.list();
		if (obj == null) {
			return null;
		}
		return (List<OrderDetail>) obj;
	}
}
