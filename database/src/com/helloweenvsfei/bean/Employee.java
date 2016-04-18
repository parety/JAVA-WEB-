package com.helloweenvsfei.bean;

import java.sql.Date;

public class Employee {

	private Department department;

	private Integer id;

	private String name;

	private String sex;

	private Date employedDate;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getEmployedDate() {
		return employedDate;
	}

	public void setEmployedDate(Date employedDate) {
		this.employedDate = employedDate;
	}

}
