package com.helloweenvsfei.xml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySaxHandler extends DefaultHandler {

	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private String content;

	// 事件发生时元素中的字符
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		content = new String(ch, start, length);
	}

	// 当解析到元素的结束标签时触发
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// 判断元素解析的名称
		if ("title".equals(qName)) {
			System.out.println("标题: " + content);
		} else if ("author".equals(qName)) {
			System.out.println("作者: " + content);
		} else if ("email".equals(qName)) {
			System.out.println("电子邮件: " + content);
		} else if ("body".equals(qName)) {
			System.out.println("内容: " + content);
		} else if ("date".equals(qName)) {
			System.out.println("发表日期: " + content);
		}
	}

	// 当解析到元素的开始标签时触发
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// 元素名为article
		if ("article".equals(qName)) {
			System.out.println("\r\n找到一篇文章. 所属分类: "
					+ attributes.getValue("category") + ". ");
		}
	}

}
