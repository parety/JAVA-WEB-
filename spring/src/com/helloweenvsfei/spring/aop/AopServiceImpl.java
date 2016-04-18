package com.helloweenvsfei.spring.aop;

import javax.security.auth.login.AccountException;

public class AopServiceImpl implements IAopService {

	private String name;

	public void withAop() throws Exception {

		System.out.println("��AOP�ĺ������С�name: " + name);

		if (name.trim().length() == 0)
			throw new AccountException("name���Բ���Ϊ��");
	}

	public void withoutAop() throws Exception {
		System.out.println("û��AOP�ĺ������С�");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
