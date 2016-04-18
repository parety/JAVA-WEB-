package com.helloweenvsfei.firstweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8606938422723524862L;

	/**
	 * Constructor of the object.
	 */
	public HelloServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ���� request��response ���뷽ʽ
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// �����ĵ�����
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// ������ͻ��������
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
		out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String requestURI = request.getRequestURI();
		out.println("<form action='" + requestURI + "' method='post'>");
		out.println("�������������֣�<input type='text' name='name' />");
		out.println("<input type='submit' />");
		out.println("</form>");
		out.println("");
		
		// ȡ������ύ�� name ����
		String name = request.getParameter("name");
		
		// ��� name ��Ϊ���ҳ��ȴ��� 0
		if(name != null && name.trim().length() > 0){
			out.println("����, <b>" + name + "</b>. ��ӭ���� Java Web ����. ");
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
