package com.framgia.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.framgia.model.OrderDetail;
import com.framgia.model.Product;


public class ProductDAO extends GenericDAO<Product, Long> implements IProductDAO {
	public ProductDAO() {
		super(Product.class);
	}

	public List<Product> findByShopId(long shopId) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Restrictions.eq("shopId", shopId));
		Object obj = criteria.list();
		if (obj == null) {
			return null;
		}
		return (List<Product>) obj;
	}

}
