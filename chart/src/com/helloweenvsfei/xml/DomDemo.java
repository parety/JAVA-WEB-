package com.helloweenvsfei.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomDemo {

	public static void main(String[] args) {
		// 创建解析的xml文档对象，其保存在E盘的根目录下的article.xml文件
		File xmlFile = new File("E:\\article.xml");
		// 声明一个 DocumentBuilder对象. 抽象类，不能直接构建，可以通过 DocumentFactory 来构建。
		DocumentBuilder builder = null;
		// 声明一个 DocumentBuilderFactory对象. 通过单例模式创建
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		// 取得默认的 DocumentBuilder.
		try {
			builder = builderFactory.newDocumentBuilder();
			// 解析文件
			Document document = builder.parse(xmlFile);
			// 获得根元素
			Element root = document.getDocumentElement();
			System.out.println("根元素：" + root.getNodeName());
			// 获得根元素下的子节点
			NodeList childNodes = root.getChildNodes();
			// 遍历这些子节点
			for (int i = 0; i < childNodes.getLength(); i++) {
				// 对每个子节点进行判断
				Node node = childNodes.item(i);
				// 如果节点的名称为"article"
				if ("article".equals(node.getNodeName())) {
					// 输出article元素属性category
					System.out.println("\r\n找到一篇文章. 所属分类: "
							+ node.getAttributes().getNamedItem("category")
									.getNodeValue() + ". ");
					// 获得<article>元素下的所有节点
					NodeList nodeDetail = node.getChildNodes();
					// 遍历<article>元素下的所有节点
					for (int j = 0; j < nodeDetail.getLength(); j++) {
						// 获得<article>元素每一个节点
						Node detail = nodeDetail.item(j);
						// 根据节点名称解析数据
						if ("title".equals(detail.getNodeName()))
							System.out
									.println("标题: " + detail.getTextContent());
						else if ("author".equals(detail.getNodeName()))
							System.out
									.println("作者: " + detail.getTextContent());
						else if ("email".equals(detail.getNodeName()))
							System.out.println("电子邮件: "
									+ detail.getTextContent());
						else if ("date".equals(detail.getNodeName()))
							System.out.println("发表日期: "
									+ detail.getTextContent());
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
