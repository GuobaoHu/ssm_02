package com.guyue.ssm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.guyue.ssm.mapper.ItemsCustomMapper;
import com.guyue.ssm.mapper.ItemsMapper;
import com.guyue.ssm.po.Items;
import com.guyue.ssm.po.ItemsCustom;
import com.guyue.ssm.po.ItemsCustomVo;
import com.guyue.ssm.po.ItemsExample;
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
	public void updateItemsById(Integer id, ItemsCustomVo itemsCustomVo) throws Exception {
		//首先进行业务校验，通常对关键参数进行校验，例如id是否为空,为空则抛出异常
		if(id == null) {
			return;
		}
		
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setId(id);
		//此处为什么有id这个参数，是因为开发出的service有可能是给写controller的人用，告诉对方此处需要传入id
		itemsCustomVo.setItems(itemsCustom);
		
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustomVo.getItemsCustom());
	}

	//批量删除
	@Override
	public void delItems(Integer[] items_id) throws Exception {
		ItemsExample example = new ItemsExample();
		
		ItemsExample.Criteria criteria = example.createCriteria();
		List<Integer> values = new ArrayList<Integer>();
		if(items_id == null || items_id.length == 0) {
			return;
		}
		for(Integer id : items_id) {
			values.add(id);
		}
		criteria.andIdIn(values);		
		itemsMapper.deleteByExample(example);
		
	}

	/**
	 * 批量修改商品信息
	 */
	@Override
	public void modifyItemsList(ItemsCustomVo itemsCustomVo) throws Exception {
		
		List<ItemsCustom> itemsCustomList = itemsCustomVo.getItemsCustomList();
		for(ItemsCustom itemsCustom : itemsCustomList) {
			ItemsExample example = new ItemsExample();
			ItemsExample.Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(itemsCustom.getId());
			itemsMapper.updateByExampleSelective(itemsCustom, example);
		}
		
	}	

	

}
