package edu.autocar.cmmn.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

public class BaseInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	ServletContext context;

	String getUrl(HttpServletRequest request) {
		String url = request.getRequestURI().substring(context.getContextPath().length());
		String query = request.getQueryString();
		if (query != null) {
			url = url + "?" + query;
		}
		return url;
	}

	void saveFlash(HttpServletRequest request, HttpServletResponse response, String target, String reason) {
		FlashMap flashMap = new FlashMap();
		flashMap.put("target", target);
		flashMap.put("reason", reason);
		FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request);
		flashMapManager.saveOutputFlashMap(flashMap, request, response);
	}

	public void redirect(HttpServletRequest request, HttpServletResponse response, String target, String reason)
			throws Exception {
		String url = getUrl(request);
		saveFlash(request, response, url, reason);
		response.sendRedirect(context.getContextPath() + target);
	}
}
