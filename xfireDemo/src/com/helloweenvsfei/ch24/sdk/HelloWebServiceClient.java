package com.helloweenvsfei.ch24.sdk;

import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import com.helloweenvsfei.ch24.IHelloWebService;
import com.helloweenvsfei.ch24.auth.PasswordHandler;

public class HelloWebServiceClient {

	private static IHelloWebService service;

	private HelloWebServiceClient() {
	}

	public static IHelloWebService getService(String serviceURL )
			throws MalformedURLException {
		if (service == null) {
			// 创建IHelloWebService的服务
			Service srvcModel = new ObjectServiceFactory()
					.create(IHelloWebService.class);
			// 创建XFire对象
			XFireProxyFactory factory = new XFireProxyFactory(XFireFactory
					.newInstance().getXFire());
			// 调用Web服务
			service = (IHelloWebService) factory.create(srvcModel, serviceURL);
			// 设置客户端调用的属性
			Client client = Client.getInstance(service);
	        client.addOutHandler(new DOMOutHandler());
	        Properties properties = new Properties();
	        //设置认证类型为加密
	        properties.setProperty(WSHandlerConstants.ACTION,WSHandlerConstants.ENCRYPT);
	        //设置用户名
	        properties.setProperty(WSHandlerConstants.ENCRYPTION_USER, "admin");
	      	//根据用户名查询出对应的密码
	        properties.setProperty(WSHandlerConstants.PW_CALLBACK_CLASS, PasswordHandler.class.getName());
	        //设置公钥文件地址
	        properties.setProperty(WSHandlerConstants.ENC_PROP_FILE,"META-INF/xfire/outsecurity.properties");
	        client.addOutHandler(new WSS4JOutHandler(properties));
//			client.addOutHandler( new ClientAuthenticationHandler("admin","1234"));
			// client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, "300");
			// client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE,"true");
			// client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE,
			// "true");
			// //如果需要设置代理
			// client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_HOST,"192.168.8.122");
			// client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_PORT,"8080");

		}
		return service;
	}

	public static void main(String[] args) {
		try {
			// 调用客户端
			// IHelloWebService service =
			// HelloWebServiceClient.getService("http://localhost:8080/xfire/services/HelloWebService");
			IHelloWebService service = HelloWebServiceClient
					.getService("http://localhost:8080/xfire/services/HelloWebServiceSign");
			System.out.println(service.sayHello("Web Service"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
