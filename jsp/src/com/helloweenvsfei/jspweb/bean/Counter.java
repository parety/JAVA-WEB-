package com.helloweenvsfei.jspweb.bean;

public class Counter {
	
	private int count;

	// ÿ����һ�Σ��������Լ�һ
	public int getCount() {
		return ++count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
