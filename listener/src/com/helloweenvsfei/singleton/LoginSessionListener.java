package com.helloweenvsfei.singleton;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoginSessionListener implements HttpSessionAttributeListener {

	Log log = LogFactory.getLog(this.getClass());

	Map<String, HttpSession> map = new HashMap<String, HttpSession>();

	public void attributeAdded(HttpSessionBindingEvent event) {

		String name = event.getName();

		// ��¼
		if (name.equals("personInfo")) {

			PersonInfo personInfo = (PersonInfo) event.getValue();

			if (map.get(personInfo.getAccount()) != null) {

				// map ���м�¼���������ʺ������������ϵ�¼��������ǰ�ĵ�¼ʧЧ
				HttpSession session = map.get(personInfo.getAccount());
				PersonInfo oldPersonInfo = (PersonInfo) session
						.getAttribute("personInfo");

				log.info("�ʺ�" + oldPersonInfo.getAccount() + "��"
						+ oldPersonInfo.getIp() + "�Ѿ���¼���õ�¼���������ߡ�");

				session.removeAttribute("personInfo");
				session.setAttribute("msg", "�����ʺ��Ѿ������������ϵ�¼�����������ߡ�");
			}

			// ��session���û���Ϊ����������map��
			map.put(personInfo.getAccount(), event.getSession());
			log.info("�ʺ�" + personInfo.getAccount() + "��" + personInfo.getIp()
					+ "��¼��");
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {

		String name = event.getName();

		// ע��
		if (name.equals("personInfo")) {
			// ����session��map���Ƴ�
			PersonInfo personInfo = (PersonInfo) event.getValue();
			map.remove(personInfo.getAccount());
			log.info("�ʺ�" + personInfo.getAccount() + "ע����");
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {

		String name = event.getName();

		// û��ע��������£�����һ���ʺŵ�¼
		if (name.equals("personInfo")) {

			// �Ƴ��ɵĵĵ�¼��Ϣ
			PersonInfo oldPersonInfo = (PersonInfo) event.getValue();
			map.remove(oldPersonInfo.getAccount());

			// �µĵ�¼��Ϣ
			PersonInfo personInfo = (PersonInfo) event.getSession()
					.getAttribute("personInfo");

			// ҲҪ����µ�¼���ʺ��Ƿ��ڱ�Ļ����ϵ�¼��
			if (map.get(personInfo.getAccount()) != null) {
				// map ���м�¼���������ʺ������������ϵ�¼��������ǰ�ĵ�¼ʧЧ
				HttpSession session = map.get(personInfo.getAccount());
				session.removeAttribute("personInfo");
				session.setAttribute("msg", "�����ʺ��Ѿ������������ϵ�¼�����������ߡ�");
			}
			map.put("personInfo", event.getSession());
		}

	}

}
