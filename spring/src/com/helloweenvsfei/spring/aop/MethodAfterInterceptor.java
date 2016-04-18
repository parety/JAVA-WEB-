package com.helloweenvsfei.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MethodAfterInterceptor implements AfterReturningAdvice {

	public void afterReturning(Object value, Method method, Object[] args,
			Object instance) throws Throwable {

		System.out.println("���� " + method.getName() + "������ϣ�����ֵΪ��" + value);

	}

}
