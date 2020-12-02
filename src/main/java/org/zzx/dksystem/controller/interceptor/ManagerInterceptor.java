package org.zzx.dksystem.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import org.zzx.dksystem.controller.WebConstant;


public class ManagerInterceptor implements HandlerInterceptor
{
	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception
	{
		// 获取HttpSession中的level属性
		var level = (String) request.getSession()
			.getAttribute(WebConstant.LEVEL);
		// 如果level不为null，且level为mgr
		if (level != null && level.equals(WebConstant.MGR_LEVEL))
		{
			return true;
		}
		// 如果用户没有登录，则设置提示信息，跳转到登录页面
		request.setAttribute("tip", "请先以经理账号登录再使用经理的功能");
		request.getRequestDispatcher("login").forward(request, response);
		// 返回false，不再执行后续处理
		return false;
	}
}
