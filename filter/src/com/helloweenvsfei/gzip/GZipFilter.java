package com.helloweenvsfei.gzip;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GZipFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String acceptEncoding = request.getHeader("Accept-Encoding");
		System.out.println("Accept-Encoding: " + acceptEncoding);

		if (acceptEncoding != null
				&& acceptEncoding.toLowerCase().indexOf("gzip") != -1) {

			// ����ͻ������֧�� GZIP ��ʽ, ��ʹ�� GZIP ѹ������
			GZipResponseWrapper gzipResponse = new GZipResponseWrapper(response);
			chain.doFilter(request, gzipResponse);

			// ���ѹ������
			gzipResponse.finishResponse();

		} else {
			// ����, ��ѹ��
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
