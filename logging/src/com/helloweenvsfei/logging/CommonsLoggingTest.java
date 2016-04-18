package com.helloweenvsfei.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLoggingTest {

	public static Log log = LogFactory.getLog(CommonsLoggingTest.class);

	public static void main(String[] args) {

		log.trace("trace ��Ϣ");
		log.trace("trace һ���쳣", new NullPointerException());

		log.debug("debug ��Ϣ");
		log.debug("debug һ���쳣", new NullPointerException());

		log.info("info ��Ϣ");
		log.info("info һ���쳣", new NullPointerException());

		log.warn("warn ��Ϣ");
		log.warn("warn һ���쳣", new NullPointerException());

		log.error("error ��Ϣ");
		log.error("error һ���쳣", new NullPointerException());

		log.fatal("fatal ��Ϣ");
		log.fatal("fatal һ���쳣", new NullPointerException());
	}

}
