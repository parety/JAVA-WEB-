package com.helloweenvsfei.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.helloweenvsfei.exception.AccountException;
import com.helloweenvsfei.exception.BusinessException;

public class ExceptionHandlerFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		try {
			chain.doFilter(request, response);
		} catch (Exception e) {

			Throwable rootCause = e;

			while (rootCause.getCause() != null) {
				rootCause = rootCause.getCause();
			}

			String message = rootCause.getMessage();

			message = message == null ? "“Ï≥££∫" + rootCause.getClass().getName()
					: message;

			request.setAttribute("message", message);
			request.setAttribute("e", e);

			if (rootCause instanceof AccountException) {
				request.getRequestDispatcher("/accountException.jsp").forward(
						request, response);
			} else if (rootCause instanceof BusinessException) {
				request.getRequestDispatcher("/businessException.jsp").forward(
						request, response);
			} else {
				request.getRequestDispatcher("/exception.jsp").forward(request,
						response);
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
