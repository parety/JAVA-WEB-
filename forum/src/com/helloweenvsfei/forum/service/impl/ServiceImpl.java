package com.helloweenvsfei.forum.service.impl;

import java.util.List;

import com.helloweenvsfei.forum.bean.BaseBean;
import com.helloweenvsfei.forum.dao.IDao;
import com.helloweenvsfei.forum.service.IService;

public abstract class ServiceImpl<T extends BaseBean> implements IService<T> {

	protected IDao<T> dao;

	public IDao<T> getDao() {
		return dao;
	}

	public void setDao(IDao<T> dao) {
		this.dao = dao;
	}

	public T find(Class<T> clazz, int id) {
		return dao.find(clazz, id);
	}

	public abstract void create(T baseBean);

	public void delete(T baseBean) {
		baseBean.setDeleted(true);
		dao.save(baseBean);
	}

	public int getTotalCount(String hql, Object... params) {
		return dao.getTotalCount(hql, params);
	}

	public void save(T baseBean) {
		dao.save(baseBean);
	}

	public List<T> list(String hql) {
		return dao.list(hql);
	}

	public List<T> list(String hql, int firstResult, int maxSize,
			Object... params) {
		return dao.list(hql, firstResult, maxSize, params);
	}

}
