package com.guyue.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guyue.ssm.po.ItemsCustom;

/**
 * 测试json的数据交互
 * @author guyue
 *
 */
@Controller
public class TestJsonController {

	@RequestMapping("requestJson")
	public @ResponseBody ItemsCustom requetsJson(@RequestBody ItemsCustom itemsCustom) throws Exception {
		
		
		return itemsCustom;
	}
	
	@RequestMapping("responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom) throws Exception {
		return itemsCustom;
	}
	
}
