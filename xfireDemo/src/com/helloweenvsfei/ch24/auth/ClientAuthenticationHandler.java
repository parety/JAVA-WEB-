package com.helloweenvsfei.ch24.auth;

import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;
import org.jdom.Namespace;

public class ClientAuthenticationHandler extends AbstractHandler {
	//soap消息的命名空间
	final Namespace ns = Namespace.getNamespace("http://www.helloweenvsfei.com");

	//用户名和密码
	private String username = null;
	private String password = null;

	public ClientAuthenticationHandler() {
	}

	public ClientAuthenticationHandler(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void invoke(MessageContext context) throws Exception {

		//创建header节点
		Element el = new Element("header", ns);
		//将节点增加到soap消息中
		context.getOutMessage().setHeader(el);
		//增加认证身份信息
		Element auth = new Element("AuthenticationToken", ns);
		Element usernameElement = new Element("username", ns);
		usernameElement.addContent(username);
		Element passwordElement = new Element("password", ns);
		passwordElement.addContent(password);
		auth.addContent(usernameElement);
		auth.addContent(passwordElement);
		//将认证身份信息添加到header中
		el.addContent(auth);

	}
}
