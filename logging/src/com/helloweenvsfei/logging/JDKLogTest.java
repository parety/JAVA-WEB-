package com.helloweenvsfei.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDKLogTest {

	public static Logger log = Logger.getLogger(JDKLogTest.class.toString());

	static {
		// ���һ������̨���������Ϊ FINE ����
		Handler console = new ConsoleHandler();
		console.setLevel(Level.FINE);

		// ��ӵ� log ��
		log.addHandler(console);
	}

	public static void main(String[] args) {

		// ���� log ����Ϊ FINE
		log.setLevel(Level.FINE);

		// ���м�������
		log.finest("finest");
		log.finer("finer");
		log.fine("fine");

		log.config("config");

		log.info("info");
		log.warning("warning");
		log.severe("servere");
	}
}
