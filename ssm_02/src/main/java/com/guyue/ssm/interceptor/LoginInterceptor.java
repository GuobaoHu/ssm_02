package com.guyue.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//如果是公共资源，则通过
		String url = request.getRequestURI();
		if(url != null && url.indexOf("login.action") >= 0) {
			return true;
		}
		
		
		//如果用户已经登录，则通过
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username != null && !username.trim().equals("")) {
			return true;
		}
		
		//上面的验证都没通过，这时候需要进行拦截,返回登录页面		
		request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
