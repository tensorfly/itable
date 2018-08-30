package com.chinaso.behavior.Util;

import javax.servlet.http.HttpServletRequest;


public final class HttpUtil {

	public HttpUtil() {
	}

	public static String getServletPathAndQueryString(HttpServletRequest request) {
		if (null == request) {
			return null;
		}
		return request.getRequestURI() + "?" + request.getQueryString();
	}
	
}
