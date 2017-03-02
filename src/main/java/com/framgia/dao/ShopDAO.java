package com.framgia.dao;

import com.framgia.model.Shop;

public class ShopDAO extends GenericDAO<Shop, Integer> implements IShopDAO {
	public ShopDAO() {
		super(Shop.class);
	}
}
