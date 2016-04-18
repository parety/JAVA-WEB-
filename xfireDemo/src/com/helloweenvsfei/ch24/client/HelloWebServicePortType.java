
package com.helloweenvsfei.ch24.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "HelloWebServicePortType", targetNamespace = "http://ch24.helloweenvsfei.com")
@SOAPBinding(use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface HelloWebServicePortType {

	@WebMethod(operationName = "sayHello", action = "")
	@WebResult(name = "out", targetNamespace = "http://ch24.helloweenvsfei.com")
	public String sayHello(
			@WebParam(name = "in0", targetNamespace = "http://ch24.helloweenvsfei.com")
			String in0);

}
