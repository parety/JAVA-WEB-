package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Article;
import com.helloweenvsfei.hibernate.bean.Type;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedTypeArticle {

	public static void main(String[] args) throws Exception {

		Type type = new Type();
		type.setName("ѧ������");

		Article article = new Article();
		article.setType(type);
		article.setName("����ʱ���ŵ�С˵�о�");
		article.setContent("  ����ʱ�����й��ŵ�С˵�ĸ߷�ʱ�ڣ�ӿ����һ�������С˵���Ĵ��������ǲ������ʱ�ڡ�");

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();

		session.persist(article);

		List<Article> list = session.createQuery(
				" select a from Article a where a.name like '%����%'  ").list();

		for (Article a : list) {
			System.out.println("���" + a.getType().getName());
			System.out.println("���⣺" + a.getName());
			System.out.println("��Ҫ��" + substring(a.getContent(), 50));
			System.out.println("----------------------");
		}

		session.getTransaction().commit();
		session.close();

	}

	private static String substring(String content, int i) {
		return content == null ? "" : content.length() < i + 1 ? content
				: content.substring(0, i);
	}
}
