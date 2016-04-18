package com.helloweenvsfei.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5446593186536558309L;
	
	public ImageServlet() {
		System.out.println("���ڼ��� " + this.getClass().getName() + " ... ");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String referer = request.getHeader("referer");

		// ���ֱ���������ַ�������Ǵӱ����վ�򿪵ģ���ʾ������Ϣ��
		if(referer == null 
				|| !referer.toLowerCase().startsWith("http://" + request.getServerName().toLowerCase())){
			// ��ͼƬ error.gif
			request.getRequestDispatcher("/error.gif").forward(request, response);
			return;
		}

		String requestURI = request.getRequestURI();
		String fileName = requestURI.substring(requestURI.lastIndexOf("/") + 1);
		
		// ������ļ�λ��
		File file = new File(this.getServletContext().getRealPath("upload"), fileName);
		this.log("�����ļ� " + file.getAbsolutePath());

		// ����ļ������ڣ���ʾ������Ϣ
		if(!file.exists()){
			response.getWriter().println("File " + requestURI + " doesn't exist. ");
			return;
		}
		
		// ���ô򿪷�ʽΪ inline��������д�
		response.setHeader("Content-Disposition", "inline;filename=" + file.getName());
		response.setHeader("Connection", "close");
		
		if(fileName.toLowerCase().endsWith(".jpg"))
			// .jpg ͼƬ��ʽ
			response.setHeader("Content-Type", "image/jpeg");
		else if(fileName.toLowerCase().endsWith(".gif"))
			// .gif ͼƬ��ʽ
			response.setHeader("Content-Type", "image/gif");
		else if(fileName.toLowerCase().endsWith(".doc"))
			// word ��ʽ
			response.setHeader("Content-Type", "application/msword");
		else
			// ������ʽ
			response.setHeader("Content-Type", "application/octet-stream");  
		
		// ͨ�� ins ��ȡ�ļ�
		InputStream ins = new FileInputStream(file);
		// ͨ�� ous ���͸��ͻ���
		OutputStream ous = response.getOutputStream();
		
		try{
			// ����
			byte[] buffer = new byte[1024];
			int len = 0;
			
			// ��ȡ�ļ����ݲ��������͸��ͻ��������
			while((len=ins.read(buffer)) > -1){
				ous.write(buffer, 0, len);
			}
		}finally{
			if(ous != null)	ous.close();
			if(ins != null)	ins.close();
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
	}
	
}
