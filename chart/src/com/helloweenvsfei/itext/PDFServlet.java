package com.helloweenvsfei.itext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDFServlet extends HttpServlet {

	private static final long serialVersionUID = -1770041214313726383L;

	public PDFServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 创建文档对象，A4纸大小
		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, stream);
			// 打开文档
			document.open();
			// 在pdf文件中写入文字
			document.add(new Paragraph("Hello World, Hello iText"));
			// 关闭文档
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 设置响应文档类型为pdf
		response.setContentType("application/pdf");
		// 设置响应数据大小
		response.setContentLength(stream.size());
		// 获得响应数据流
		ServletOutputStream out = response.getOutputStream();
		// 将pdf数据流写入到响应数据流中
		stream.writeTo(out);
		out.flush();
		out.close();

	}

}
