package com.guyue.ssm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.guyue.ssm.mapper.ItemsCustomMapper;
import com.guyue.ssm.po.ItemsCustom;
import com.guyue.ssm.po.ItemsCustomVo;
import com.guyue.ssm.service.ItemsCustomService;

public class ItemsCustomServiceImp implements ItemsCustomService {
	//自动注入mapper的属性
	@Autowired
	private ItemsCustomMapper itemsCustomMapper;
	
	@Override
	public List<ItemsCustom> findItemsByName(ItemsCustomVo itemsCustomVo) throws Exception {
		
		return itemsCustomMapper.findItemsByName(itemsCustomVo);
		
	}

}
