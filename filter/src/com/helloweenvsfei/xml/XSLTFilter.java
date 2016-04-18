package com.helloweenvsfei.xml;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTFilter implements Filter {

	private ServletContext servletContext;

	public void init(FilterConfig config) throws ServletException {
		servletContext = config.getServletContext();
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// ��ʽ�����ļ���/book.xsl
		Source styleSource = new StreamSource(servletContext
				.getRealPath("/MessageLog.xsl"));

		// ����� xml �ļ�
		Source xmlSource = new StreamSource(servletContext.getRealPath(request
				.getRequestURI().replace(request.getContextPath() + "", "")));
		try {

			// ת��������
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();

			// ת����
			Transformer transformer = transformerFactory
					.newTransformer(styleSource);

			// ��ת���Ľ�����浽�ö�����
			CharArrayWriter charArrayWriter = new CharArrayWriter();
			StreamResult result = new StreamResult(charArrayWriter);

			// ת��
			transformer.transform(xmlSource, result);

			// ���ת����Ľ��
			response.setContentType("text/html");
			response.setContentLength(charArrayWriter.toString().length());
			PrintWriter out = response.getWriter();
			out.write(charArrayWriter.toString());

		} catch (Exception ex) {
		}
	}

	public void destroy() {
	}
}
