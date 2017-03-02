package com.framgia.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.framgia.bean.ShopInfo;
import com.framgia.bean.UserInfo;
import com.framgia.model.Shop;
import com.framgia.model.User;
import com.framgia.util.Helpers;

public class UserService extends BaseService implements IUserService {

	private static final Logger logger = Logger.getLogger(UserService.class);

	@Override
	public List<UserInfo> findAll() {
		try {
			List<User> userList = userDAO.findAll();
			if (!Helpers.isEmpty(userList)) {
				List<UserInfo> userInfoList = new ArrayList<UserInfo>();
				for (User user : userList) {
					UserInfo userInfo = new UserInfo();
					BeanUtils.copyProperties(user, userInfo);
					ShopInfo shopInfo = new ShopInfo();
					BeanUtils.copyProperties(user.getShop(), shopInfo);
					userInfo.setShopInfo(shopInfo);
					userInfoList.add(userInfo);
				}
				logger.debug("find all user: " + userInfoList);
				return userInfoList;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public void addUser(UserInfo userInfo) {
		logger.debug("persisting user instance");
		try {
			User user = new User();
			user.setId(userInfo.getId());
			user.setPassword(userInfo.getPassword());
			user.setRole(userInfo.getRole());
			user.setShop(new Shop(userInfo.getShopInfo().getId()));
			user.setStatus(userInfo.getStatus());
			user.setUsername(userInfo.getUsername());
			User result = userDAO.save(user);
			logger.debug("save successful user :" + result);
		} catch (Exception e) {
			logger.error("An exception save user: " + e);
		}

	}

}
