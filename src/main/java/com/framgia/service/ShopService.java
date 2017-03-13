package com.framgia.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.framgia.bean.OrderDetailInfo;
import com.framgia.bean.ShopInfo;
import com.framgia.bean.UserInfo;
import com.framgia.model.Shop;
import com.framgia.util.Helpers;

public class ShopService extends BaseService implements IShopService {

	private static final Logger logger = Logger.getLogger(ShopService.class);

	@Override
	public List<ShopInfo> getListShop() {
		try {
			List<Shop> listShop = shopDAO.findAll();
			if (!Helpers.isEmpty(listShop)) {
				List<ShopInfo> listShopInf = new ArrayList<ShopInfo>();
				for (Shop shop : listShop) {
					ShopInfo shopInfo = new ShopInfo();
					shopInfo.setAddress(shop.getAddress());
					shopInfo.setId(shop.getId());
					shopInfo.setName(shop.getName());
					List<OrderDetailInfo> listOrderDetailInfo = new ArrayList<OrderDetailInfo>();
					BeanUtils.copyProperties(shop.getOrderDetails(), listOrderDetailInfo);
					shopInfo.setOrderDetailsInfo(listOrderDetailInfo);
					shopInfo.setTel(shop.getTel());
					List<UserInfo> listUserInfo = new ArrayList<UserInfo>();
					BeanUtils.copyProperties(shop.getUsers(), listUserInfo);
					shopInfo.setUsersInfo(listUserInfo);
					listShopInf.add(shopInfo);
				}
				logger.debug("get all shop :" + listShopInf);
				return listShopInf;
			}
		} catch (Exception e) {
			logger.debug("An exception find all shop:" + e);
		}
		return null;
	}

	@Override
	public boolean addShop(ShopInfo shopInfo) {
		logger.debug("persisting shop instance");
		try {
			Shop shop = new Shop();
			shop.setId(shopInfo.getId());
			shop.setAddress(shopInfo.getAddress());
			shop.setName(shopInfo.getName());
			shop.setTel(shopInfo.getTel());
			shop = shopDAO.save(shop);
			logger.debug("save successful shop :" + shop);
			return true;
		} catch (Exception e) {
			logger.error("An exception save shop: " + e);
		}
		return false;
	}

	@Override
	public ShopInfo findShopById(int id) {
		try {
			Shop shop = shopDAO.findById(new Integer(id));
			ShopInfo shopInfo = new ShopInfo();
			shopInfo.setAddress(shop.getAddress());
			shopInfo.setId(shop.getId());
			shopInfo.setName(shop.getName());
			shopInfo.setTel(shop.getTel());

			logger.debug("get shop by id: " + shopInfo);
			return shopInfo;
		} catch (Exception e) {
			logger.error("an exception get shop by id:" + e);
		}

		return null;
	}

	@Override
	public boolean editShop(ShopInfo shopInfo) {
		try {
			Shop shop = new Shop();
			shop.setAddress(shopInfo.getAddress());
			shop.setId(shopInfo.getId());
			shop.setName(shopInfo.getName());
			shop.setTel(shopInfo.getTel());
			shop = shopDAO.save(shop);
			logger.debug("edit shop successful" + shop);
			return true;
		} catch (Exception e) {
			logger.error("an exception edit shop: " + e);
		}
		return false;
	}

}
