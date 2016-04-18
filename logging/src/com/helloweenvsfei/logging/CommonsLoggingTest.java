package com.helloweenvsfei.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLoggingTest {

	public static Log log = LogFactory.getLog(CommonsLoggingTest.class);

	public static void main(String[] args) {

		log.trace("trace 信息");
		log.trace("trace 一个异常", new NullPointerException());

		log.debug("debug 信息");
		log.debug("debug 一个异常", new NullPointerException());

		log.info("info 信息");
		log.info("info 一个异常", new NullPointerException());

		log.warn("warn 信息");
		log.warn("warn 一个异常", new NullPointerException());

		log.error("error 信息");
		log.error("error 一个异常", new NullPointerException());

		log.fatal("fatal 信息");
		log.fatal("fatal 一个异常", new NullPointerException());
	}

}
