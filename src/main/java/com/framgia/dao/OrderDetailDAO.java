package com.framgia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.framgia.model.OrderDetail;

public class OrderDetailDAO extends GenericDAO<OrderDetail, Long> implements IOderDetailDAO {
	public OrderDetailDAO() {
		super.setPersistentClass(OrderDetail.class);
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

}
