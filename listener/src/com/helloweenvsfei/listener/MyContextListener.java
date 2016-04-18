package com.helloweenvsfei.listener;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.helloweenvsfei.util.ApplicationConstants;

public class MyContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		// ����ʱ����¼����������ʱ��
		ApplicationConstants.START_DATE = new Date();
	}

	public void contextDestroyed(ServletContextEvent event) {
		// �ر�ʱ������������Ҳ���Խ�������浽Ӳ���ϡ�
		ApplicationConstants.START_DATE = null;
		ApplicationConstants.MAX_ONLINE_COUNT_DATE = null;
	}
}
