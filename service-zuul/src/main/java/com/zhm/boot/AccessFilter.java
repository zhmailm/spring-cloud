package com.zhm.boot;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter {
	private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	public boolean shouldFilter() {
		return true;
	}

	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		Object accessToken = request.getParameter("accessToken");

		logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
		if (accessToken == null) {
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
		}
		return null;
	}
}