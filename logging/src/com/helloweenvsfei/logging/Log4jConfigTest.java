package com.helloweenvsfei.logging;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jConfigTest {

	public Logger log = Logger.getLogger(Log4jConfigTest.class);

	public void test() {

		// 配置文件路径
		PropertyConfigurator.configure("src/Log4jConfigTest.properties");

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {

				if (log.isDebugEnabled())
					log.debug("开始计算 " + i + " * " + j + " 次运算");

				// 或者
				// if (log.isEnabledFor(Priority.WARN))
				// log.warn("开始计算 " + i + " * " + j + " 次运算");
			}
		}

		new Thread(new Runnable() {
			public void run() {
				// log.error("debug 级别的输出");
				log.error("ERROR 级别的输出");
			}
		}).start();

		// log.error("debug 级别的输出");
		log.info("INFO 级别的输出");
		log.warn("WARN 级别的输出");
		log.error("ERROR 级别的输出");

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
