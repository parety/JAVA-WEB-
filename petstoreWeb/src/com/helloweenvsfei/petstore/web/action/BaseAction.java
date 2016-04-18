package com.helloweenvsfei.petstore.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.helloweenvsfei.petstore.entity.CategoryEO;
import com.helloweenvsfei.petstore.util.BOClient;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = -6650676160387569187L;

	protected String action;

	protected String title;

	protected String message;

	protected CategoryEO rootCategoryEO;

	public List<CategoryEO> getCategoryEOList() {

		try {
			return BOClient.lookupICategory().list(
					" from CategoryEO c where c.parent = null ");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return new ArrayList<CategoryEO>();
	}

	public CategoryEO getRootCategoryEO() {

		if (rootCategoryEO == null) {
			rootCategoryEO = new CategoryEO();
			rootCategoryEO.setId(0);
			rootCategoryEO.setName("所有类别");
			rootCategoryEO.getSubCategories().addAll(getCategoryEOList());
		}

		return rootCategoryEO;
	}

	public void setRootCategoryEO(CategoryEO rootCategoryEO) {
		this.rootCategoryEO = rootCategoryEO;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
