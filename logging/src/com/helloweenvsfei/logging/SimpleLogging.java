package com.helloweenvsfei.logging;

public class SimpleLogging {

	public static boolean debug = false;

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (debug)
					System.out.println("进行第 " + i + " * " + j + " 次计算");
			}
		}
	}
}
