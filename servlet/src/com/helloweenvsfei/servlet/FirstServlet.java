package com.helloweenvsfei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2386052823761867369L;
	
	/**
	 * �� GET ��ʽ����ҳ��ʱִ�иú�����
	 * ִ�� doGet ǰ����ִ�� getLastModified�������������� getLastModified ���ص���ֵ
	 * ���ϴη���ʱ���ص���ֵ��ͬ������Ϊ���ĵ�û�и��£���������û������ִ�� doGet��
	 * ��� getLastModified ���� -1������Ϊ��ʱ�̸��µģ�����ִ�иú�����
	 */ 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ���� HttpServlet �Դ�����־���������Ϣ������̨
		this.log("ִ�� doGet ����... ");

		// ���� doGet
		this.execute(request, response);
	}

	/**
	 * �� POST ��ʽ����ҳ��ʱִ�иú�����
	 */ 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.log("ִ�� doPost ����... ");
		
		// ���� doPost
		this.execute(request, response);
	}
	
	/**
	 * ���ظ� Servlet ���ɵ��ĵ��ĸ���ʱ�䡣�� Get ��ʽ������Ч��
	 * ���ص�ʱ��Ϊ����� 1970��1��1��08:00:00 �ĺ�������
	 * ���Ϊ -1 ����Ϊ��ʵʱ���¡�Ĭ��Ϊ -1��
	 */
	@Override
	public long getLastModified(HttpServletRequest request) {
		
		this.log("ִ�� getLastModified ����... ");
		
		return 0;
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// ���ʸ� Servlet �� URI
		String requestURI = request.getRequestURI();
		// ���ʸ� Servlet �ķ�ʽ���� GET ���� POST
		String method = request.getMethod();
		// �ͻ����ύ�Ĳ��� param ֵ
		String param = request.getParameter("param");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("	�� " + method + " ��ʽ���ʸ�ҳ�档ȡ���� param ����Ϊ��" + param + "<br/>");
		
		out.println("	<form action='" + requestURI + "' method='get'><input type='text' name='param' value=''><input type='submit' value='�� GET ��ʽ���� RequestServlet'></form>");
		out.println("	<form action='" + requestURI + "' method='post'><input type='text' name='param' value=''><input type='submit' value='�� POST ��ʽ���� RequestServlet'></form>");
		
		// �ɿͻ����������ȡ���ĵ��ĸ���ʱ��
		out.println("	<script>document.write('��ҳ��������ʱ�䣺' + document.lastModified + '<br />'); </script>");
		out.println("	<script>document.write('��ҳ��URL��' + location + '<br/>' ); </script>");
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
	}

}
