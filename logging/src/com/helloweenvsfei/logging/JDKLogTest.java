package com.helloweenvsfei.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDKLogTest {

	public static Logger log = Logger.getLogger(JDKLogTest.class.toString());

	static {
		// 添加一个控制台输出，设置为 FINE 级别
		Handler console = new ConsoleHandler();
		console.setLevel(Level.FINE);

		// 添加到 log 中
		log.addHandler(console);
	}

	public static void main(String[] args) {

		// 设置 log 级别为 FINE
		log.setLevel(Level.FINE);

		// 所有级别的输出
		log.finest("finest");
		log.finer("finer");
		log.fine("fine");

		log.config("config");

		log.info("info");
		log.warning("warning");
		log.severe("servere");
	}
}
