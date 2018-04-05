package com.guyue.ssm.service;

import java.util.List;

import com.guyue.ssm.po.Items;
import com.guyue.ssm.po.ItemsCustom;
import com.guyue.ssm.po.ItemsCustomVo;

public interface ItemsCustomService {
	public List<ItemsCustom> findItemsByName(ItemsCustomVo itemsCustomVo) throws Exception;
	
	/**
	 * 执行修改之前，先查询数据库中的对应的id的商品信息，并将信息显示在页面上
	 * @param id 查询的id,之所以用Integer,是为了方便后面对id是否为空进行验证
	 * @return 返回的是Items的信息
	 * @throws Exception
	 */
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	/**
	 * 修改对应id的商品信息
	 * @param id 商品的id
	 * @param itemsCustom ItemsCustom对象，其中封装商品需要修改的信息
	 * @throws Exception
	 */
	public void updateItemsById(Integer id, ItemsCustomVo itemsCustomVo) throws Exception;

	public void delItems(Integer[] items_id) throws Exception;
	
	public void modifyItemsList(ItemsCustomVo itemsCustomVo) throws Exception;
	
}
