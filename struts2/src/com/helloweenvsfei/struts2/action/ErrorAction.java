package com.helloweenvsfei.struts2.action;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;

import com.opensymphony.xwork2.ActionSupport;

@Results(value = { @Result(name = "input", value = "/errorInput.jsp") })
public class ErrorAction extends ActionSupport {

	private static final long serialVersionUID = 6606367670105178335L;

	public String execute() {
		return INPUT;
	}

	public String error() {

		this.addActionError("ִ�� error() �������׳��˵�һ�� error ��Ϣ��");
		this.addActionError("ִ�� error() �������׳��˵ڶ��� error ��Ϣ��");
		
		return INPUT;
	}

	public String message() {

		this.addActionMessage("ִ�� message() �������׳��˵�һ�� message ��Ϣ��");
		this.addActionMessage("ִ�� message() �������׳��˵ڶ��� message ��Ϣ��");

		return INPUT;
	}

	public String fieldError() {
		
		this.addFieldError("username", "����д�û�����");
		this.addFieldError("password", "���벻��Ϊ�ա�");

		return INPUT;
	}

}
