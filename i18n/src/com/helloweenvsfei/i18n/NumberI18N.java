package com.helloweenvsfei.i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

public class NumberI18N {

	public static void main(String[] args) {

		// ���ڸ�ʽ
		String s1 = DateFormat.getDateInstance().format(new Date());
		// ʱ���ʽ
		String s2 = DateFormat.getTimeInstance().format(new Date());
		// ʱ�����ڸ�ʽ
		String s3 = DateFormat.getDateTimeInstance().format(new Date());

		// ���ָ�ʽ
		String n1 = NumberFormat.getInstance().format(10000.2345);
		// ���Ҹ�ʽ
		String n2 = NumberFormat.getCurrencyInstance().format(23.34);
		// �ٷֱȸ�ʽ
		String n3 = NumberFormat.getPercentInstance().format(2345.0d);
	}
}
