package com.framgia.dao;

import java.util.List;

import com.framgia.model.Shop;

public interface IShopDAO extends IGenericDAO<Shop, Integer>{
	
	public List<Shop> searchShop(Shop shop);
}
