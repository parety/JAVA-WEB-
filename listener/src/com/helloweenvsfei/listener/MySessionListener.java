package com.helloweenvsfei.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.helloweenvsfei.util.ApplicationConstants;

public class MySessionListener implements HttpSessionListener,
		HttpSessionAttributeListener {

	public void sessionCreated(HttpSessionEvent sessionEvent) {

		HttpSession session = sessionEvent.getSession();

		// �� session ���� map
		ApplicationConstants.SESSION_MAP.put(session.getId(), session);
		// �ܷ�������++
		ApplicationConstants.TOTAL_HISTORY_COUNT++;

		// �����ǰ��������������ʷ��¼������������������������¼ʱ��
		if (ApplicationConstants.SESSION_MAP.size() > ApplicationConstants.MAX_ONLINE_COUNT) {
			ApplicationConstants.MAX_ONLINE_COUNT = ApplicationConstants.SESSION_MAP
					.size();
			ApplicationConstants.MAX_ONLINE_COUNT_DATE = new Date();
		}
	}

	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		HttpSession session = sessionEvent.getSession();
		// ��session��map���Ƴ�
		ApplicationConstants.SESSION_MAP.remove(session.getId());
	}

	public void attributeAdded(HttpSessionBindingEvent event) {

		if (event.getName().equals("personInfo")) {

			// ��ǰ��¼�û���++
			ApplicationConstants.CURRENT_LOGIN_COUNT++;
			HttpSession session = event.getSession();

			// ���Ҹ��ʺ���û�������������ϵ�¼
			for (HttpSession sess : ApplicationConstants.SESSION_MAP.values()) {

				// ������ʺ��Ѿ������������ϵ�¼������ǰ�ĵ�¼ʧЧ
				if (event.getValue().equals(sess.getAttribute("personInfo"))
						&& session.getId() != sess.getId()) {
					sess.invalidate();
				}
			}
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {

		// ע�� ��ǰ��¼�û���--
		if (event.getName().equals("personInfo")) {
			ApplicationConstants.CURRENT_LOGIN_COUNT--;
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {

		// ���µ�¼
		if (event.getName().equals("personInfo")) {
			HttpSession session = event.getSession();
			for (HttpSession sess : ApplicationConstants.SESSION_MAP.values()) {
				// ������ʺ������������ϵ�¼��������ǰ��¼ʧЧ
				if (event.getValue().equals(sess.getAttribute("personInfo"))
						&& session.getId() != sess.getId()) {
					sess.invalidate();
				}
			}
		}
	}

}
