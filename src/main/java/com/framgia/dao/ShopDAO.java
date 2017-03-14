package com.framgia.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.framgia.model.Shop;
import com.framgia.util.Helpers;

public class ShopDAO extends GenericDAO<Shop, Integer> implements IShopDAO {
	public ShopDAO() {
		super(Shop.class);
	}

	@Override
	public List<Shop> searchShop(Shop shop) {
		Criteria criterial = getSession().createCriteria(getPersistentClass());
		List<Shop> list = new ArrayList<Shop>();
		if (!Helpers.isEmpty(shop.getName())) {
			criterial.add(Restrictions.like("name", "%" + shop.getName() + "%"));
		}
		if (!Helpers.isEmpty(shop.getAddress())) {
			criterial.add(Restrictions.like("address", "%" + shop.getAddress() + "%"));
		}
		if (!Helpers.isEmpty(shop.getTel())) {
			criterial.add(Restrictions.eq("tel", shop.getTel()));
		}
		list = criterial.list();
		return list;
	}
}
