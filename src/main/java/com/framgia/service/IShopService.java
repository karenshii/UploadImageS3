package com.framgia.service;

import java.util.List;

import com.framgia.bean.ShopInfo;

public interface IShopService extends IBaseService {

	public List<ShopInfo> getListShop();

	public boolean addShop(ShopInfo shopInfo);

	public ShopInfo findShopById(int id);

	public boolean editShop(ShopInfo shopInfo);

}
