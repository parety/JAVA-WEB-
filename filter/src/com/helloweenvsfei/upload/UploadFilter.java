package com.helloweenvsfei.upload;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UploadFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		UploadRequestWrapper uploadRequest = new UploadRequestWrapper(
				(HttpServletRequest) request);

		chain.doFilter(uploadRequest, response);

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
