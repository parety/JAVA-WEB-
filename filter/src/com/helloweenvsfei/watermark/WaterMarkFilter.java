package com.helloweenvsfei.watermark;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WaterMarkFilter implements Filter {

	// ˮӡͼƬ�������ڳ�ʼ��������
	private String waterMarkFile;

	public void init(FilterConfig config) throws ServletException {
		String file = config.getInitParameter("waterMarkFile");
		waterMarkFile = config.getServletContext().getRealPath(file);
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// �Զ����response
		WaterMarkResponseWrapper waterMarkRes = new WaterMarkResponseWrapper(
				response, waterMarkFile);

		chain.doFilter(request, waterMarkRes);

		// ��ˮӡ��������ͻ��������
		waterMarkRes.finishResponse();
	}

	public void destroy() {
	}

}
