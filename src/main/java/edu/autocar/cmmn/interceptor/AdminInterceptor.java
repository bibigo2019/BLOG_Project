package edu.autocar.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

public class AdminInterceptor extends BaseInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		/*
		 * Member member = (Member) session.getAttribute("USER"); if (member == null ||
		 * !member.isAdmin()) { // 관리자 인지 여부 판단 redirect(request, response, "/login",
		 * "관리자 권한이 필요합니다."); return false; }
		 */
		return super.preHandle(request, response, handler);
	}
}
