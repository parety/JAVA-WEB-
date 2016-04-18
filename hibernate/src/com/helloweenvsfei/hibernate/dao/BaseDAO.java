package com.helloweenvsfei.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class BaseDAO<T> {

	/**
	 * ��������
	 * 
	 * @param object
	 */
	public void create(T object) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();

		try {
			session.beginTransaction();

			session.persist(object);

			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * �������ݿ�
	 * 
	 * @param object
	 */
	public void update(T object) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();

		try {
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * �����ݿ���ɾ��
	 * 
	 * @param object
	 */
	public void delete(T object) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();

		try {
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * ���ҵ���Entity Bean
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T find(Class<? extends T> clazz, Serializable id) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			return (T) session.get(clazz, id);
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	/**
	 * ���Ҷ��Entity Bean
	 * 
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(String hql) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();
			return session.createQuery(hql).list();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}
}
