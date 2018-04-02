package com.guyue.ssm.service.imp;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.guyue.ssm.mapper.ItemsCustomMapper;
import com.guyue.ssm.mapper.ItemsMapper;
import com.guyue.ssm.po.Items;
import com.guyue.ssm.po.ItemsCustom;
import com.guyue.ssm.po.ItemsCustomVo;
import com.guyue.ssm.service.ItemsCustomService;

public class ItemsCustomServiceImp implements ItemsCustomService {
	//自动注入mapper的属性
	@Autowired
	private ItemsCustomMapper itemsCustomMapper;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsByName(ItemsCustomVo itemsCustomVo) throws Exception {
		
		return itemsCustomMapper.findItemsByName(itemsCustomVo);
		
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		//1.查询对应的id的商品信息
		Items items = itemsMapper.selectByPrimaryKey(id);
		
		//2.对查询出的信息进行业务处理(例如针对日期，做一些是否过期的判断等)
		//....
		
		//3.创建ItemsCustom对象，将Items中的信息拷贝到ItemsCustom中
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateItemsById(Integer id, ItemsCustom itemsCustom) throws Exception {
		//首先进行业务校验，通常对关键参数进行校验，例如id是否为空,为空则抛出异常
		//...
		
		//此处为什么有id这个参数，是因为开发出的service有可能是给写controller的人用，告诉对方此处需要传入id
		itemsCustom.setId(id);
		
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}	

	

}
