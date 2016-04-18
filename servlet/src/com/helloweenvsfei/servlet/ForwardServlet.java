package com.helloweenvsfei.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet {

	private static final long serialVersionUID = -291840563095094360L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String destination = request.getParameter("destination");
		
		// ��ת�� /WEB-INF/web.xml��ͨ����ַ��������ַ�ǲ��ܷ��ʵ����ļ��ģ����� forward ����
		if("file".equals(destination)){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/web.xml");
			dispatcher.forward(request, response);
		}
		// ��ת�� /forward.jsp
		else if("jsp".equals(destination)){
			// ͨ�� setAttribute ��������һ�� Date ����� JSP ҳ��
			Date date = new Date();
			request.setAttribute("date", date);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/forward.jsp");
			dispatcher.forward(request, response);
		}
		// ��ת����һ�� Servlet
		else if("servlet".equals(destination)){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/LifeCycleServlet");
			dispatcher.forward(request, response);
		}
		else{
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println("ȱ�ٲ������÷���" + request.getRequestURL() + "?destination=jsp ���� file ���� servlet ");
		}
		
	}
	public void doPut(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doGet(request, response);
	}

}
