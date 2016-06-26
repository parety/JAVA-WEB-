package com.xiewei.spring.example;

import org.springframework.beans.factory.BeanNameAware;

public class WhatsTheNameBean implements BeanNameAware {

	private String beanName;

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

}
