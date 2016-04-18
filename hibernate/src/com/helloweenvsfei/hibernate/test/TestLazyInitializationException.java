package com.helloweenvsfei.hibernate.test;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Email;
import com.helloweenvsfei.hibernate.bean.Person2;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestLazyInitializationException {

	static int createdId = 0;

	static {// ����ص�ʱ�򱣴�һ��Person

		Person2 person = new Person2();// ��ʼ��һ�� Person ʵ��
		person.setName("Jane");

		Email email = new Email();
		email.setEmail("yahoo@yahoo.com.cn");
		person.getEmails().add(email);

		Session session = HibernateSessionFactory.getSession(); // �����Ự
		session.beginTransaction(); // ��������

		session.persist(person);// ���浽���ݿ�
		createdId = person.getId();// ��ID��������

		session.getTransaction().commit();// �ύ����
		session.close(); // �رջỰ
	}

	public static void main(String[] args) throws Exception {

		Session session = HibernateSessionFactory.getSession();// ��ѯ���ÿ�������
		Person2 p = (Person2) session.get(Person2.class, createdId);
		session.close();

		try {
			List<Email> list = p.getEmails(); // �������ݣ������׳��쳣

			System.out.println(p.getName() + " �ĵ����ʼ�: ");
			for (Email mail : list) {	// ѭ�����Email
				System.out.println("\t" + mail.getEmail());
			}
		} catch (Exception e) {
			String title = e.getClass().getName();
			String msg = e.getMessage().replace(",", ",\r\n").replace(":",
					":\r\n");
			JOptionPane.showMessageDialog(null, msg, title,
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
