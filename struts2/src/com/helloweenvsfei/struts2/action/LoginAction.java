package com.helloweenvsfei.struts2.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 7912892052170751803L;

	// �ʺ�
	private String account;

	// ����
	private String password;

	// ������ ����û�������ƥ�� �򷵻سɹ�ҳ�� ���򷵻ص�¼ҳ��
	public String execute() {

		if ("helloween".equalsIgnoreCase(account) && "1234".equals(password)) {
			return SUCCESS;
		}

		return LOGIN;
	}

	public String login() {

		// ��ȡ request��response
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		// ���ʺŷŵ� session ��
		HttpSession session = request.getSession(true);
		session.setAttribute("account", account);

		// ��ȡwebӦ�ø�Ŀ¼�� /upload �ļ���
		ServletContext context = ServletActionContext.getServletContext();
		File uploadFile = new File(context.getRealPath("upload"));

		return execute();
	}

	public String logout() {
		// ע������
		return "logout";
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
