package edu.autocar.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends BaseInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		/*
		if (session.getAttribute("USER") == null) { // 로그인 여부 판단
			redirect(request, response, "/login", "로그인이 필요한 서비스입니다.");
			return false;
		}
		*/
		return super.preHandle(request, response, handler);
	}
}
