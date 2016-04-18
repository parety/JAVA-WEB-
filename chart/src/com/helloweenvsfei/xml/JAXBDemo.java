package com.helloweenvsfei.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBDemo {

	public static void main(String[] args) {
		// 创建xml文档对象，其保存在E盘的根目录下的test.xml文件
		File xmlFile = new File("E:\\test.xml");
		//声明JAXBContext上下文对象
		JAXBContext context;
		try {
			//通过指定映射的类创建上下文
			context = JAXBContext.newInstance(Article.class);
			//通过上下文创建java转化xml的对象Marshaller
//			Marshaller m = context.createMarshaller();
//			//创建xml中的数据
//			Article article = new Article();
//			article.setAuthor("Janet");
//			article.setDate("20080801");
//			article.setEmail("janetvsfei@yahoo.com.cn");
//			article.setTitle("XML");
//			//将java对象转化到xml
//			m.marshal(article, xmlFile);
			
			//通过上下文创建xml转化java的对象Unmarshaller
			Unmarshaller u = context.createUnmarshaller();
			Article article = (Article)u.unmarshal(xmlFile);
			System.out.println(article.getAuthor());
			System.out.println(article.getDate());
			System.out.println(article.getEmail());
			System.out.println(article.getTitle());
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
