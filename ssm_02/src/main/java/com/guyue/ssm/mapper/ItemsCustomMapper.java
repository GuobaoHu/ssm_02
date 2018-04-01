package com.guyue.ssm.mapper;

import java.util.List;

import com.guyue.ssm.po.ItemsCustom;
import com.guyue.ssm.po.ItemsCustomVo;

public interface ItemsCustomMapper {
	public List<ItemsCustom> findItemsByName(ItemsCustomVo itemsCustomVo) throws Exception;
}
