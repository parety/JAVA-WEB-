package com.helloweenvsfei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadSafetyServlet extends HttpServlet {

	private static final long serialVersionUID = 2957055449370562943L;

	private String name;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		name = request.getParameter("name");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}

		response.getWriter().println("����, " + name + ". ��ʹ���� GET ��ʽ�ύ����");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		name = request.getParameter("name");

		response.getWriter().println("����, " + name + ". ��ʹ���� POST ��ʽ�ύ����");
	}
}
