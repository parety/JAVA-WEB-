package com.helloweenvsfei.i18n;

import java.util.Locale;

public class LocaleUtil {

	public static void main(String[] args) {

		Locale[] availableLocales = Locale.getAvailableLocales();

		for (Locale locale : availableLocales) {

			System.out.print(locale.getDisplayCountry() + "("
					+ locale.getCountry() + "), \t");
			System.out.print(locale.getDisplayLanguage() + "("
					+ locale.getLanguage() + "), \t");
			System.out.print(locale.getVariant());

			System.out.println();
		}
	}
}
