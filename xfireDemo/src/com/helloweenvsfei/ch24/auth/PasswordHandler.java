package com.helloweenvsfei.ch24.auth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;
public class PasswordHandler implements CallbackHandler {

	//保存用户名和密码的哈希表
	private Map<String,String> passwords = new HashMap<String,String>();

	public PasswordHandler() {
		passwords.put("admin", "123");
        passwords.put("janet","456");

	}

	//回调该方法
	public void handle(Callback[] callbacks) throws IOException,UnsupportedCallbackException {
		
		//获得密码回调方法
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		//获得用户名
		String id = pc.getIdentifer();
		//根据用户名在哈希表中取出密码，并设置到密码回调方法中
		pc.setPassword(passwords.get(id));

	}

}
