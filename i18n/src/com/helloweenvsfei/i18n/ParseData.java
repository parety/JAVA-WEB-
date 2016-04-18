package com.helloweenvsfei.i18n;

import java.text.NumberFormat;
import java.util.Locale;

public class ParseData {

	public static void main(String[] args) throws Exception {

		Locale.setDefault(Locale.GERMAN);

		String number = "1.000";

		double d = NumberFormat.getNumberInstance().parse(number).doubleValue();

		System.out.println(d);

		System.out.println(Double.parseDouble(number));

	}

}
