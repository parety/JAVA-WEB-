package com.helloweenvsfei.hibernate.dao;

import java.io.Serializable;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Event;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class EventDAO<T extends Event> extends BaseDAO<T> {

	@Override
	@SuppressWarnings("all")
	public T find(Class<? extends T> clazz, Serializable id) {

		Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		try {
			session.beginTransaction();

			T event = (T) session.get(clazz, id);

			// ��ʾ�ĵ��� getCat().getName()��������
			event.getCat().getName();

			return event;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}
}
