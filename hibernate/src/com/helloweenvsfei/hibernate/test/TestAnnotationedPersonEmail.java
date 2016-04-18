package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Email;
import com.helloweenvsfei.hibernate.bean.Person2;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedPersonEmail {

	public static void main(String[] args) throws Exception {

		Person2 person = new Person2();
		person.setName("Jane");

		Email email = new Email();
		email.setEmail("yahoo@yahoo.com.cn");
		person.getEmails().add(email);

		email = new Email();
		email.setEmail("163@163.com");
		person.getEmails().add(email);

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();

		// ���� Person ���󣬻��Զ��������� Email ����
		session.persist(person);

		// ����ӵ�� �Ż��������� �������û�
		List list = session.createQuery(
				" select p from Person2 p left join fetch p.emails e "
						+ " where e.email like '%@yahoo.com.cn' ").list();

		// ����û��������е��û�
		for (Person2 p : (List<Person2>) list) {
			System.out.println("Person: " + p.getName());
			for (Email e : p.getEmails()) {
				System.out.println("\tEmail: " + e.getEmail());
			}
		}

		// ɾ�� Person ���󣬻��Զ�����ɾ���������� Email ���ݿ��¼
		session.delete(person);

		session.getTransaction().commit();
		session.close();

	}
}
