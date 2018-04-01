package com.guyue.ssm.service;

import java.util.List;

import com.guyue.ssm.po.ItemsCustom;
import com.guyue.ssm.po.ItemsCustomVo;

public interface ItemsCustomService {
	public List<ItemsCustom> findItemsByName(ItemsCustomVo itemsCustomVo) throws Exception;
}
