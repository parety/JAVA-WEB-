package com.helloweenvsfei.itext;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class FirstPDF {

	public static void main(String[] args) {
		// 创建文档对象，A4纸大小
		Document document = new Document(PageSize.A4);
		try {
			// 输出为E:\itext.pdf文件
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("E:\\itext.pdf "));
			//设置文档作者
			document.addAuthor("Helloween");
			//设置文档标题
			document.addTitle("This is itext pdf file");
			//设置主题
			document.addSubject("First pdf");
			//设置关键字
			document.addKeywords("iText");

			// 打开文档
			document.open();
			// 在pdf文件中写入文字
			document.add(new Paragraph("Hello World, Hello iText"));
			//设置字体的文字
			document.add(new Paragraph("Hello World, Hello iText",FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC)));
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
			//设置为中文
			Paragraph pragraph=new Paragraph("你好,这是中文", FontChinese);  
			document.add(pragraph);
			
			// 创建2行3列的表
			Table table = new Table(3, 2);
			// 设置表格边框颜色
			table.setBorderColor(new Color(220, 100, 100));
			// 设置表格边距
			table.setPadding(5);
			// 设置表格间距
			table.setSpacing(3);
			// 设置表格线条宽度
			table.setBorderWidth(3);
			//创建单元格对象
			Cell cell = new Cell(" Header 1 ");
			//将单元格添加到表格中
			table.addCell(cell);
			cell = new Cell(" Header 2 ");
			//设置单元格占2列
			cell.setColspan(2);
			table.addCell(cell);
			//将普通文本添加到表格中
			table.addCell(" Cell 1 ");
			table.addCell(" Cell 2 ");
			table.addCell(" Cell 3 ");
			//将表格添加到文档中
			document.add(table);


			//创建图片对象，参数为图片的文件名
			Image bmp = Image.getInstance("E:\\Java_logo.jpg");
			bmp.scalePercent(25f);
			document.add(bmp);
			
			// 关闭文档
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
