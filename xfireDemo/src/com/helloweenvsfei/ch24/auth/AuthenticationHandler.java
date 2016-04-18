package com.helloweenvsfei.ch24.auth;

import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.fault.XFireFault;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;
import org.jdom.Namespace;

public class AuthenticationHandler extends AbstractHandler {

	// soap消息的命名空间
	private final static Namespace ns = Namespace
			.getNamespace("http://www.helloweenvsfei.com");

	// 验证身份
	public void invoke(MessageContext context) throws Exception {
		// 判断是否带有soap头
		if (context.getInMessage().getHeader() == null) {
			throw new XFireFault("请求必须包含身份验证信息", XFireFault.SENDER);
		}
		// 从soap头中获取身份信息
		Element token = context.getInMessage().getHeader().getChild(
				"AuthenticationToken", ns);
		if (token == null) {
			throw new XFireFault("请求必须包含身份验证信息", XFireFault.SENDER);
		}
		// 从soap头中获取用户名和密码
		String username = token.getChild("username", ns).getValue();
		String password = token.getChild("password", ns).getValue();

		// 验证用户名密码
		if (!username.equals("admin") || !password.equals("123"))
			throw new XFireFault("非法的用户名和密码", XFireFault.SENDER);

		// 验证通过，可设置上下文属性
		context.setProperty("username", username);

	}

}
