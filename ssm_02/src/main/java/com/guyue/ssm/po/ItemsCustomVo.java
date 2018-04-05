package com.guyue.ssm.po;

import java.util.List;
import java.util.Map;

public class ItemsCustomVo {
	private Items items;
	private ItemsCustom itemsCustom;
	
	private List<ItemsCustom> itemsCustomList;
	
	private Map<String, String> testMap;
	
	public Map<String, String> getTestMap() {
		return testMap;
	}
	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}
	public List<ItemsCustom> getItemsCustomList() {
		return itemsCustomList;
	}
	public void setItemsCustomList(List<ItemsCustom> itemsCustomList) {
		this.itemsCustomList = itemsCustomList;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
}
