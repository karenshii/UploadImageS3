package com.framgia.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.framgia.bean.UserInfo;
import com.framgia.model.User;
import com.framgia.util.Helpers;

public class UserService extends BaseService implements IUserService {

	private static final Logger logger = Logger.getLogger(UserService.class);

	public List<UserInfo> findAll() {
		try {
			List<User> userList = userDAO.findAll();
			if (!Helpers.isEmpty(userList)) {
				List<UserInfo> userInfoList = new ArrayList<UserInfo>();
				for (User user : userList) {
					UserInfo userInfo = new UserInfo();
					BeanUtils.copyProperties(user, userInfo);
					userInfoList.add(userInfo);
				}
				return userInfoList;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

}
