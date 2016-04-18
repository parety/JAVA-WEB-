package com.helloweenvsfei.petstore.util;

public class StringUtil {

	public static String breakString(String ss, int length) {
		StringBuffer buffer = new StringBuffer();
		String[] words = ss.split(" ");
		int currLineLength = 0;
		for (String word : words) {
			if (currLineLength + word.length() > length) {
				buffer.append("\r\n").append(word);
				currLineLength = 0;
			} else {
				buffer.append(" " + word);
				currLineLength += word.length() + 1;
			}
		}
		return buffer.toString();
	}

}
