package com.helloweenvsfei.ch24;

public class HelloWebServiceImpl implements IHelloWebService {
	
	public String sayHello(String message) {
		return "Hello,"+ message;
	}
	
}