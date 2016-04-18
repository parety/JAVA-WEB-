package com.helloweenvsfei.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SessionAttributeListenerTest implements
		HttpSessionAttributeListener {

	Log log = LogFactory.getLog(getClass());

	// �������
	public void attributeAdded(HttpSessionBindingEvent se) {
		HttpSession session = se.getSession();
		String name = se.getName();
		log.info("�½�session���ԣ�" + name + ", ֵΪ��" + se.getValue());
	}

	// ɾ������
	public void attributeRemoved(HttpSessionBindingEvent se) {
		HttpSession session = se.getSession();
		String name = se.getName();
		log.info("ɾ��session���ԣ�" + name + ", ֵΪ��" + se.getValue());
	}

	// �޸�����
	public void attributeReplaced(HttpSessionBindingEvent se) {
		HttpSession session = se.getSession();
		String name = se.getName();
		Object oldValue = se.getValue();
		log.info("�޸�session���ԣ�" + name + ", ԭֵ��" + oldValue + ", ��ֵ��"
				+ session.getAttribute(name));
	}
}
