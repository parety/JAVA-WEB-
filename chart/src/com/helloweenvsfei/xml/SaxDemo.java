package com.helloweenvsfei.xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxDemo {

	public static void main(String[] args) {
		// 创建解析的xml文档对象，其保存在E盘的根目录下的article.xml文件
		File xmlFile = new File("E:\\article.xml");
		// 创建一个 SAXParserFactory对象. 通过单例模式创建
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			// 创建SAXParser对象
			SAXParser parser = factory.newSAXParser();
			// 解析文件,并定义解析时的事件处理
			parser.parse(xmlFile, new MySaxHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
