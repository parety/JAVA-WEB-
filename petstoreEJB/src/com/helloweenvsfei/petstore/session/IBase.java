package com.helloweenvsfei.petstore.session;

import java.util.List;

import javax.persistence.Query;

public interface IBase<T> {

	/**
	 * ��ѯ����
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T find(Class<? extends T> clazz, int id);

	/**
	 * ��Ӷ���
	 * 
	 * @param t
	 * @return
	 */
	public T persist(T t);

	/**
	 * �������
	 * 
	 * @param t
	 * @return
	 */
	public T merge(T t);

	/**
	 * ɾ������
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T remove(Class<? extends T> clazz, int id);

	/**
	 * ɾ������
	 * 
	 * @param t
	 * @return
	 */
	public T remove(T t);

	/**
	 * �г����ж���
	 * 
	 * @param clazz
	 * @return
	 */
	public List<T> listAll(Class<? extends T> clazz);

	public List<T> list(String jpql);

	/**
	 * ��ѯ���ж������
	 * 
	 * @param clazz
	 * @return
	 */
	public int getTotalCount(Class<? extends T> clazz);

	/**
	 * �г��� firstResult ��ʼ�� maxResult ������
	 * 
	 * @param clazz
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<T> list(Class<? extends T> clazz, int firstResult, int maxResult);

	/**
	 * ��ѯ���� hql �Ķ������
	 * 
	 * @param jpql
	 * @return
	 */
	public int getTotalCount(String jpql);

	/**
	 * �г��� firstResult ��ʼ�� maxResult ������
	 * 
	 * @param jpql
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<T> list(String jpql, int firstResult, int maxResult);

	/**
	 * ���� Query ����
	 * 
	 * @param jpql
	 * @return
	 */
	public Query createQuery(String jpql);

}
