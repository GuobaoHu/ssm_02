package com.guyue.ssm.controller;

import java.awt.Dialog.ModalExclusionType;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.portlet.MockActionRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.guyue.ssm.po.Items;
import com.guyue.ssm.po.ItemsCustom;
import com.guyue.ssm.po.ItemsCustomVo;
import com.guyue.ssm.po.User;
import com.guyue.ssm.service.ItemsCustomService;

@Controller
@RequestMapping(value="items")
public class ItemsCustomController {
	
	@Autowired
	private ItemsCustomService itemsCustomService;
	
	/**
	 * 使用ItemsCustomVo做为查询的形参，在访问的url页面中进行输入
	 * @param itemsCustomVo 包装类型作为形参，可以很方便地将页面中的input里面的参数进行分类，避免参数传入到不合适的对象中
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="queryItems",method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView findItemsByName(ItemsCustomVo itemsCustomVo, User user) throws Exception {
		List<ItemsCustom> itemsList = itemsCustomService.findItemsByName(itemsCustomVo);
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
	public void nonReturn(HttpServletRequest request, HttpServletResponse response, ItemsCustomVo itemsCustomVo) throws Exception {
		//request.getRequestDispatcher("queryItems.action").forward(request, response);
		
		response.sendRedirect("queryItems.action");
	}
	
	//商品修改成功的提示
	@RequestMapping("editItemsSubmit")
	public String editItemsSubmit(Model model,String name, ItemsCustomVo itemsCustomVo, @Validated ItemsCustom itemsCustom, BindingResult result) throws Exception {
		
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			model.addAttribute("allErrors", allErrors);
			return "editItems.jsp";
		}
		
		itemsCustomService.updateItemsById(itemsCustomVo.getItemsCustom().getId(), itemsCustomVo);
		return "success.jsp";
	}
	
	//批量删除商品
	@RequestMapping("delItems")
	public ModelAndView delItems(Integer[] items_id) throws Exception {
		//删除操作
		itemsCustomService.delItems(items_id);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success.jsp");
		return modelAndView;
		
	}
	
	//展现商品信息，可以修改的
	@RequestMapping(value="editItemsList",method={RequestMethod.POST,RequestMethod.GET})
	public String findItemsForModify(Model model, ItemsCustomVo itemsCustomVo) throws Exception {
		
		
		
		
		
		List<ItemsCustom> itemsList = itemsCustomService.findItemsByName(itemsCustomVo);
		model.addAttribute("itemsList", itemsList);
		return "editItemsList.jsp";
	}
	
	
	//实现批量修改商品信息
	@RequestMapping("modifyItemsList")
	public ModelAndView modifyItemsList(ItemsCustomVo itemsCustomVo) throws Exception {
		
		itemsCustomService.modifyItemsList(itemsCustomVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success.jsp");
		return modelAndView;
	}
	
	//测试map参数绑定的效果
	@RequestMapping("testMap")
	public String testMap(ItemsCustomVo itemsCustomVo) throws Exception {
		
		
		return "success.jsp";
		
	}
	
}
