package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Clazz;
import com.helloweenvsfei.hibernate.bean.Student;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXmlClazzStudent {

	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {

		Clazz clazz = new Clazz();
		clazz.setName("�������");

		Student student1 = new Student();
		student1.setName("����");
		student1.setSex("��");

		Student student2 = new Student();
		student2.setName("����");
		student2.setSex("Ů");

		Session session = HibernateXMLUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// ��������ݿ�
		session.persist(clazz);
		session.persist(student1);
		session.persist(student2);

		// ���ð༶
		student1.setClazz(clazz);
		student2.setClazz(clazz);
		// clazz.getStudents().add(student1);
		// clazz.getStudents().add(student2);

		session.getTransaction().commit();
		session.beginTransaction();

		// ��ѯ��Ϊ��������ࡱ�İ༶ Ȼ�����ѧ��
		Clazz c = (Clazz) session.createQuery(
				" select c from Clazz c where c.name = :name ").setParameter(
				"name", "�������").uniqueResult();

		session.refresh(c);

		System.out.println("������� ������ѧ����");
		for (Student s : c.getStudents()) {
			System.out.println("\t������" + s.getName() + ", �Ա�" + s.getSex());
		}

		// ֱ�Ӳ�ѯ�༶Ϊ��������ࡱ��ѧ��
		List<Student> students = session.createQuery(
				" select s from Student s where s.clazz.name = :name ")
				.setParameter("name", "�������").list();

		System.out.println("������� ������ѧ����");
		for (Student s : students) {
			System.out.println("\t������" + s.getName() + ", �Ա�" + s.getSex());
		}

		session.getTransaction().commit();
		session.close();

	}

}
