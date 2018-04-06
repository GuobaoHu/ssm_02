package com.guyue.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	//登录
	@RequestMapping("login")
	public String login(HttpSession session, String username, String password) throws Exception {
		
		session.setAttribute("username", username);
		
		return "redirect:/items/queryItems.action";
	}
	
	//退出
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		//此时已经销毁session，退出到这个页面可以测试拦截器拦截没有session时的效果
		return "redirect:/items/queryItems.action";
	}
}
