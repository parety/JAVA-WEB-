package com.helloweenvsfei.i18n;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {

	private static final String BUNDLE_NAME = "com.helloweenvsfei.i18n.param"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	/**
	 * 不带参数的资源
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * 带任意个参数的资源
	 * 
	 * @param key
	 * @param params
	 * @return
	 */
	public static String getString(String key, Object... params) {
		try {
			String value = RESOURCE_BUNDLE.getString(key);

			return MessageFormat.format(value, params);

		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	public static void main(String args[]) {
		System.out.println(getString("hello", "192.168.1.1", "zh_CN", "中文"));
	}
}
