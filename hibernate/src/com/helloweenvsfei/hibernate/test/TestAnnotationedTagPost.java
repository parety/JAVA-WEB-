package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Post;
import com.helloweenvsfei.hibernate.bean.Tag;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedTagPost {

	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {

		Tag tag = new Tag();
		tag.setName("��Ĭ");

		Tag tag2 = new Tag();
		tag2.setName("����");

		Post post = new Post();
		post.setTitle("�Ƽ�һ������Ĺ�棬����������ϢŶ");
		post.setContent("����Ƶ���Լ�����");
		post.getTags().add(tag);
		post.getTags().add(tag2);

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();

		// ��������ݿ�
		session.persist(post);

		List<Post> list = session.createQuery(
				" select p from Post p left join fetch p.tags t "
						+ " where t.name = :name ").setParameter("name", "��Ĭ")
				.list();

		System.out.println("���ǩ����Ĭ����ص����ӣ�");
		for (Post p : list) {
			// session.refresh(p);
			System.out.println("���⣺" + p.getTitle());
			System.out.print("������ǩ��");
			for (Tag t : p.getTags()) {
				System.out.print(t.getName() + ", ");
			}
			System.out.println();
		}

		session.refresh(tag);

		System.out.println("��ǩ��" + tag.getName() + "���µ�������ӣ�");
		for (Post p : tag.getPosts()) {
			System.out.println("���⣺" + p.getTitle());
			System.out.print("������ǩ��");
			for (Tag t : p.getTags()) {
				System.out.print(t.getName() + ", ");
			}
			System.out.println();
		}

		session.getTransaction().commit();
		session.close();

	}

}
