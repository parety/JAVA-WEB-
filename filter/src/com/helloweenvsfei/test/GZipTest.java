package com.helloweenvsfei.test;

import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;

public class GZipTest {

	public static void test(String url) throws Exception {

		/** ֧�� GZIP ������ */
		URLConnection connGzip = new URL(url).openConnection();
		connGzip.setRequestProperty("Accept-Encoding", "gzip");
		int lengthGzip = connGzip.getContentLength();

		/** ��֧�� GZIP ������ */
		URLConnection connCommon = new URL(url).openConnection();
		int lengthCommon = connCommon.getContentLength();

		double rate = new Double(lengthGzip) / lengthCommon;

		System.out.println("��ַ: " + url);
		System.out.println("ѹ����: " + lengthGzip + " byte, \tѹ��ǰ: "
				+ lengthCommon + " byte, \t����: "
				+ NumberFormat.getPercentInstance().format(rate));
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		test("http://localhost:8080/filter/dojo/dojo.js");
		test("http://localhost:8080/filter/image.jsp");
		test("http://localhost:8080/filter/winter.jpg");
	}
}
