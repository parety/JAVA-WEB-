package com.helloweenvsfei.logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jConfigTest {

	public Logger log = Logger.getLogger(Log4jConfigTest.class);

	public void test() {

		// �����ļ�·��
		PropertyConfigurator.configure("src/Log4jConfigTest.properties");

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {

				if (log.isDebugEnabled())
					log.debug("��ʼ���� " + i + " * " + j + " ������");

				// ����
				// if (log.isEnabledFor(Priority.WARN))
				// log.warn("��ʼ���� " + i + " * " + j + " ������");
			}
		}

		new Thread(new Runnable() {
			public void run() {
				// log.error("debug ��������");
				log.error("ERROR ��������");
			}
		}).start();

		// log.error("debug ��������");
		log.info("INFO ��������");
		log.warn("WARN ��������");
		log.error("ERROR ��������");

		try {
			String s = null;
			s.length();
		} catch (Exception e) {
			log.error(e, e);
		}

	}

	public static void main(String[] args) {
		new Log4jConfigTest().test();
	}

}
