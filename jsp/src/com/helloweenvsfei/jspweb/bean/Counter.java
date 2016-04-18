package com.helloweenvsfei.jspweb.bean;

public class Counter {
	
	private int count;

	// 每访问一次，计数器自加一
	public int getCount() {
		return ++count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
