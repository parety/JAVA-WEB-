package com.helloweenvsfei.forum.service.impl;

import java.util.List;

import com.helloweenvsfei.forum.bean.Person;
import com.helloweenvsfei.forum.service.IPersonService;
import com.helloweenvsfei.forum.struts.util.MD5Util;

public class PersonServiceImpl<T extends Person> extends ServiceImpl<T>
		implements IPersonService<T> {

	public T findPersonByAccount(String account) {

		List<T> person = this.getDao().createQuery(
				" select p from Person p "
						+ " where lower(p.account) = lower(:account) and deleted = false ")
				.setParameter("account", account.trim()).list();

		if (person.size() > 0)
			return person.get(0);

		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void create(T person) {

		if (findPersonByAccount(person.getAccount()) != null) {
			throw new RuntimeException("帐号 " + person.getAccount() + " 已经存在。");
		}

		person.setPassword(MD5Util.calc(person.getPassword()));

		this.getDao().create(person);
	}

	public T getPerson(String account, String password) {

		List<T> list = this.getDao().createQuery(
				" select p from Person p where p.account = :account "
						+ " and p.password = :password and p.deleted = false ")
				.setParameter("account", account).setParameter("password",
						MD5Util.calc(password)).list();

		if (list.size() > 0)
			return list.get(0);
		return null;
	}
}
