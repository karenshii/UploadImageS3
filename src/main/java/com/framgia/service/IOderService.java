package com.framgia.service;

import java.util.List;

import com.framgia.bean.ProductInfo;

public interface IOderService extends IBaseService {

	public boolean saveOrder(List<ProductInfo> productInfoList, long userId);
}
