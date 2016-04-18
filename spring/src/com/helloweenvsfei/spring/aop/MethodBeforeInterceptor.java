package com.helloweenvsfei.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MethodBeforeInterceptor implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object instance)
			throws Throwable {

		System.out.println("����Ҫִ�з�����" + method.getName());

		if (instance instanceof AopServiceImpl) {

			String name = ((AopServiceImpl) instance).getName();

			if (name == null)
				throw new NullPointerException("name���Բ���Ϊnull");
		}

	}

}
