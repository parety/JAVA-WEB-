package com.helloweenvsfei.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ListenerTest implements HttpSessionListener,
		ServletContextListener, ServletRequestListener {

	Log log = LogFactory.getLog(getClass());

	// ���� session
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		log.info("�´���һ��session, IDΪ: " + session.getId());
	}

	// ���� session
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		log.info("����һ��session, IDΪ: " + session.getId());
	}

	// ���� context
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		log.info("��������" + servletContext.getContextPath());
	}

	// ж�� context
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		log.info("�����ر�" + servletContext.getContextPath());
	}

	// ���� request
	public void requestInitialized(ServletRequestEvent sre) {

		HttpServletRequest request = (HttpServletRequest) sre
				.getServletRequest();

		String uri = request.getRequestURI();
		uri = request.getQueryString() == null ? uri : (uri + "?" + request
				.getQueryString());

		request.setAttribute("dateCreated", System.currentTimeMillis());

		log.info("IP " + request.getRemoteAddr() + " ���� " + uri);
	}

	// ���� request
	public void requestDestroyed(ServletRequestEvent sre) {

		HttpServletRequest request = (HttpServletRequest) sre
				.getServletRequest();

		long time = System.currentTimeMillis()
				- (Long) request.getAttribute("dateCreated");

		log.info(request.getRemoteAddr() + "���������, ��ʱ" + time + "����. ");
	}

}
