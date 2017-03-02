package com.framgia.service;

import java.util.List;

import com.framgia.bean.ShopInfo;

public interface IShopService extends IBaseService{
	
	public List<ShopInfo> getListShop();
	
}
