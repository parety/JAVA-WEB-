package com.helloweenvsfei.ch24.auth;

import java.security.cert.X509Certificate;
import java.util.Vector;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSSecurityEngineResult;
import org.apache.ws.security.WSUsernameTokenPrincipal;
import org.apache.ws.security.handler.WSHandlerConstants;
import org.apache.ws.security.handler.WSHandlerResult;
import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.handler.AbstractHandler;

import sun.security.x509.X500Name;

public class ValidateUserTokenHandler extends AbstractHandler {

	public void invoke(MessageContext context) throws Exception {
		Vector result = (Vector) context
				.getProperty(WSHandlerConstants.RECV_RESULTS);
		for (int i = 0; i < result.size(); i++) {
			WSHandlerResult res = (WSHandlerResult) result.get(i);
			for (int j = 0; j < res.getResults().size(); j++) {
				WSSecurityEngineResult secRes = (WSSecurityEngineResult) res
						.getResults().get(j);
				int action = secRes.getAction();
				//如果是用户名密码的方式
				if ((action & WSConstants.UT) > 0) {
					WSUsernameTokenPrincipal principal = (WSUsernameTokenPrincipal) secRes
							.getPrincipal();
					// 以加密方式设置请求用户名
					context.setProperty(WSHandlerConstants.ENCRYPTION_USER,
							principal.getName());
				}
				// 如果是签名的方式
				if ((action & WSConstants.SIGN) > 0) {
					X509Certificate cert = secRes.getCertificate();
					X500Name principal = (X500Name) secRes.getPrincipal();
				}
			}
		}
	}
}
