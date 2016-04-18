package com.helloweenvsfei.i18n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

public class NumberI18N {

	public static void main(String[] args) {

		// 日期格式
		String s1 = DateFormat.getDateInstance().format(new Date());
		// 时间格式
		String s2 = DateFormat.getTimeInstance().format(new Date());
		// 时间日期格式
		String s3 = DateFormat.getDateTimeInstance().format(new Date());

		// 数字格式
		String n1 = NumberFormat.getInstance().format(10000.2345);
		// 货币格式
		String n2 = NumberFormat.getCurrencyInstance().format(23.34);
		// 百分比格式
		String n3 = NumberFormat.getPercentInstance().format(2345.0d);
	}
}
