package com.helloweenvsfei.listener;

import java.io.Serializable;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PersonInfo implements HttpSessionActivationListener,
		HttpSessionBindingListener, Serializable {

	private static final long serialVersionUID = -4780592776386225973L;

	Log log = LogFactory.getLog(getClass());

	private String name;

	private Date dateCreated;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	// ��Ӳ�̼��غ�
	public void sessionDidActivate(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		log.info(this + "�Ѿ��ɹ���Ӳ���м��ء�sessionId: " + session.getId());
	}

	// �������ۻ���Ӳ��ʱ
	public void sessionWillPassivate(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		log.info(this + "�������浽Ӳ�̡�sessionId: " + session.getId());
	}

	// ���Ž�sessionǰ
	public void valueBound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		String name = event.getName();
		log.info(this + "���󶨵�session \"" + session.getId() + "\"��" + name
				+ "������");

		// ��¼�ŵ�session�е�ʱ��
		this.setDateCreated(new Date());
	}

	// ��session���Ƴ���
	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		String name = event.getName();
		log.info(this + "����session \"" + session.getId() + "\"��" + name
				+ "�������Ƴ�");
	}

	@Override
	public String toString() {
		return "PersonInfo(" + name + ")";
	}

}
