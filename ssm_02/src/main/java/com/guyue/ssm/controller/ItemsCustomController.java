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
}
