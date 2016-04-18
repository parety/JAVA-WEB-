package com.helloweenvsfei.forum.struts.form;

import org.apache.struts.action.ActionForm;

public class ForumForm extends ActionForm {

	private String action;

	private String title;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
