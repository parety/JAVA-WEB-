package com.helloweenvsfei.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterImpl implements Filter {

	private boolean enable;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// ��ʼ������
		enable = "true".equals(filterConfig.getInitParameter("enable"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("befor doFilter(). ");

		chain.doFilter(request, response);

		System.out.println("after doFitler(). ");

	}

	@Override
	public void destroy() {
		// ��Դ���ٴ���
	}
}

