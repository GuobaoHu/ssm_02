package com.guyue.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guyue.ssm.po.ItemsCustom;
import com.guyue.ssm.po.ItemsCustomVo;
import com.guyue.ssm.service.ItemsCustomService;

@Controller
public class ItemsCustomController {
	
	@Autowired
	private ItemsCustomService itemsCustomService;
	
	@RequestMapping("queryItems")
	public ModelAndView findItemsByName() throws Exception {
		List<ItemsCustom> itemsList = itemsCustomService.findItemsByName(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("itemsList.jsp");
		return modelAndView;
	}
	
	//商品修改界面的商品详情展现
	@RequestMapping("editItems")
	public ModelAndView editItems() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//查询商品信息
		ItemsCustom itemsCustom = itemsCustomService.findItemsById(1);
		
		//将商品信息(model)放到modelAndView中
		modelAndView.addObject("itemsCustom", itemsCustom);
		
		//将view添加到modelAndView中
		modelAndView.setViewName("editItems.jsp");
		
		return modelAndView;
	}
	
	//商品修改成功的提示
	@RequestMapping("editItemsSubmit")
	public ModelAndView editItemsSubmit() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("success.jsp");
		return modelAndView;
	}
}
