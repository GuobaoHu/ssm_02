package com.guyue.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor2 implements HandlerInterceptor {

	/**
	 * controller执行前会调用该方法
	 * 返回true则继续执行，返回false则终止执行
	 * 这里可以加入登录校验，权限拦截等
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("拦截器2...preHandle");
		return false;
	}

	/**
	 * controller执行后但未返回视图前调用此方法
	 * 这里可以在返回视图前对模型数据进行加工处理，比如这里可以加入公用信息以便页面显示
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("拦截器2...postHandle");
		
	}

	/**
	 * controller执行后且视图返回后执行该方法
	 * 可以得到执行controller的异常信息
	 * 这里可以记录操作日志，资源清理等
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("拦截器2...afterCompletion");
	}

}
