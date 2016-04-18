package com.helloweenvsfei.jfreechart;

import java.util.Random;

public class DataUtils {
	private static Random random = new Random();
	private static final int MAX_NUMBER = 100;

	/**
	 * 	随机在0到100间取数
	 * @return 
	 */
	public static int getRandomData() {
		return random.nextInt(MAX_NUMBER);
	}
}
