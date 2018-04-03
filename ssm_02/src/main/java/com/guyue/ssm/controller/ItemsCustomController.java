package com.guyue.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.guyue.ssm.po.ItemsCustom;
import com.guyue.ssm.po.ItemsCustomVo;
import com.guyue.ssm.service.ItemsCustomService;

@Controller
@RequestMapping(value="items")
public class ItemsCustomController {
	
	@Autowired
	private ItemsCustomService itemsCustomService;
	
	@RequestMapping(value="queryItems",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findItemsByName() throws Exception {
		List<ItemsCustom> itemsList = itemsCustomService.findItemsByName(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("itemsList.jsp");
		return modelAndView;
	}
	
	//商品修改界面的商品详情展现
	//情况一：返回ModelAndView
	@RequestMapping("editItems")
	public ModelAndView editItems(Integer id) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//查询商品信息
		ItemsCustom itemsCustom1 = itemsCustomService.findItemsById(id);
		
		//将商品信息(model)放到modelAndView中
		modelAndView.addObject("itemsCustom", itemsCustom1);
		
		//将view添加到modelAndView中
		modelAndView.setViewName("editItems.jsp");
		
		return modelAndView;
	}
	
	//情况二：返回字符串
	//2.1返回逻辑视图
	@RequestMapping("editItemsReturnString")
	public String editItemsReturnString(Model model) throws Exception {
		
			
		//查询商品信息
		ItemsCustom itemsCustom = itemsCustomService.findItemsById(1);
		
		//将商品信息(model)放到modelAndView中
		model.addAttribute("itemsCustom", itemsCustom);
		
		return "editItems.jsp";
	}
	
	//2.2返回redirect或forward的字符串
	@RequestMapping("redirectToSubmitSuccess")
	public String redirectToSubmitSuccess() throws Exception {
		/*return "redirect:queryItems.action";*/
		return "forward:queryItems.action";
	}
	
	
	//情况三：没有返回值void
	@RequestMapping("nonReturn")
	public void nonReturn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getRequestDispatcher("queryItems.action").forward(request, response);
		response.sendRedirect("queryItems.action");
	}
	
	//商品修改成功的提示
	@RequestMapping("editItemsSubmit")
	public ModelAndView editItemsSubmit(String name, ItemsCustom itemsCustom) throws Exception {
		System.out.println(name);
		System.out.println(itemsCustom.getName());
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("success.jsp");
		return modelAndView;
	}
}
