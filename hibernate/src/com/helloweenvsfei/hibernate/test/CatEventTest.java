package com.helloweenvsfei.hibernate.test;

import java.text.DateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import junit.framework.TestCase;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.bean.Event;
import com.helloweenvsfei.hibernate.dao.BaseDAO;

public class CatEventTest extends TestCase {

	public void testOneToMany() {

		// Cat
		Cat cat = new Cat();
		cat.setName("Doraemon");
		cat.setCreateDate(new Date());

		// Event
		Event event = new Event();
		event.setCat(cat);
		event.setDescription("Doraemon ȥ�Ͽ��ˡ�");
		event.setCreateDate(new Date());

		// Event
		Event event2 = new Event();
		event2.setCat(cat);
		event2.setDescription("Doraemon �ؼҼ�����塣");
		event2.setCreateDate(new Date());

		cat.getEvents().add(event);
		cat.getEvents().add(event2);

		// ����BaseDAO�������еĶ���
		BaseDAO<Object> baseDAO = new BaseDAO<Object>();
		baseDAO.create(cat);
		baseDAO.create(event);
		baseDAO.create(event2);

		// ��ѯ�ող����Cat, ����ͬ��Cat������Eventһ������
		int catId = cat.getId();
		Cat cc = (Cat) baseDAO.find(Cat.class, catId);

		// �����Cat������Event
		String s = cc.getName() + " ���н�����\r\n";
		for (Event ev : cc.getEvents()) {
			s += "    - ["
					+ DateFormat.getTimeInstance()
							.format(event.getCreateDate()) + "] "
					+ ev.getDescription() + "\r\n";
		}

		JOptionPane.showMessageDialog(null, s);
	}
}
