package com.bigman.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	/* 在controller中的方法调用之前被执行，返回值决定是否被放行 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		// 登录拦截的实现思路
		if (session.getAttribute("user") == null) {
			// 跳转到登录界面
//			request.getRequestDispatcher("/user/index.do").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/user/index.do");
			return false;
		} else {
			return true;// 已经登录，直接放行
		}
	}

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

}
