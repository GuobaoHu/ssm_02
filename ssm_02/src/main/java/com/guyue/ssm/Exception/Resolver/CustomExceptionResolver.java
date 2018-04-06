package com.guyue.ssm.Exception.Resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.guyue.ssm.Exception.CustomException;

public class CustomExceptionResolver implements HandlerExceptionResolver  {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		CustomException customException = null;
		
		//判断异常的类型是用户自定义的还是系统运行时异常
		if(ex instanceof CustomException) {
			//用户自定义
			customException = (CustomException) ex;
		} else {
			//系统运行时异常
			customException = new CustomException("未知错误");
		}
		
		//获取异常信息
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error.jsp");
		return modelAndView;
	}

}
