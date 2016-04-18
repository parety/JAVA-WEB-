package com.helloweenvsfei.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CacheFilter implements Filter {

	private ServletContext servletContext;

	// �����ļ��У�ʹ��Tomcat����Ŀ¼
	private File temporalDir;

	// ����ʱ�䣬������Filter��ʼ��������
	private long cacheTime = Long.MAX_VALUE;

	public void init(FilterConfig config) throws ServletException {
		temporalDir = (File) config.getServletContext().getAttribute(
				"javax.servlet.context.tempdir");
		servletContext = config.getServletContext();
		cacheTime = new Long(config.getInitParameter("cacheTime"));
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// ���Ϊ POST, �򲻾�������
		if ("POST".equals(request.getMethod())) {
			chain.doFilter(request, response);
			return;
		}

		// ����� URI
		String uri = request.getRequestURI();
		if (uri == null)
			uri = "";
		uri = uri.replace(request.getContextPath() + "/", "");
		uri = uri.trim().length() == 0 ? "index.jsp" : uri;
		uri = request.getQueryString() == null ? uri : (uri + "?" + request
				.getQueryString());

		// ��Ӧ�Ļ����ļ�
		File cacheFile = new File(temporalDir, URLEncoder.encode(uri, "UTF-8"));
		System.out.println(cacheFile);

		// ��������ļ������� �����Ѿ���������ʱ�� ������ Servlet
		if (!cacheFile.exists()
				|| cacheFile.length() == 0
				|| cacheFile.lastModified() < System.currentTimeMillis()
						- cacheTime) {

			CacheResponseWrapper cacheResponse = new CacheResponseWrapper(
					response);

			chain.doFilter(request, cacheResponse);

			// ������д�뻺���ļ�
			char[] content = cacheResponse.getCacheWriter().toCharArray();

			temporalDir.mkdirs();
			cacheFile.createNewFile();

			Writer writer = new OutputStreamWriter(new FileOutputStream(
					cacheFile), "UTF-8");
			writer.write(content);
			writer.close();
		}

		// �����ContentType
		String mimeType = servletContext.getMimeType(request.getRequestURI());
		response.setContentType(mimeType);

		// ��ȡ�����ļ������ݣ�д��ͻ��������
		Reader ins = new InputStreamReader(new FileInputStream(cacheFile),
				"UTF-8");
		StringBuffer buffer = new StringBuffer();
		char[] cbuf = new char[1024];
		int len;
		while ((len = ins.read(cbuf)) > -1) {
			buffer.append(cbuf, 0, len);
		}
		ins.close();
		// ������ͻ���
		response.getWriter().write(buffer.toString());
	}

	public void destroy() {
	}
}
