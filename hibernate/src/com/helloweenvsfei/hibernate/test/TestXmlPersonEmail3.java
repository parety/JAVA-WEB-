package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Person3;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXmlPersonEmail3 {

	public static void main(String[] args) throws Exception {

		Person3 person = new Person3();
		person.setName("Jane");

		person.getEmails().add("yahoo@yahoo.com.cn");
		person.getEmails().add("163@163.com");

		Session session = HibernateXMLUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// ���� Person ���󣬻��Զ��������� Email ����
		session.persist(person);

		// ����ӵ�� �Ż��������� �������û�
		List list = session.createQuery(
				" select p from Person3 p left join fetch p.emails e "
						+ " where e like '%@yahoo.com.cn' ").list();

		// ����û��������е��û�
		for (Person3 p : (List<Person3>) list) {
			System.out.println("Person: " + p.getName());
			for (String e : p.getEmails()) {
				System.out.println("\tEmail: " + e);
			}
		}

		// ɾ�� Person ���󣬻��Զ�����ɾ���������� Email ���ݿ��¼
		session.delete(person);

		session.getTransaction().commit();
		session.close();

	}
}
