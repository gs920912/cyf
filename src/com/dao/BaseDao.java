package com.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * ʵ�ֳ��÷����Ļ�����ӿ�
 * @author gs
 * T : ����  : �ɴ������е�ʵ�������Ҳ���Ǳ����
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * ���� insert
	 */
	public Serializable save(T o);
	
	/**
	 * ɾ��delete ��id
	 */
	public void delete(Serializable id);
	
	/**
	 * ɾ��delete ��class
	 */
	public void delete(T o);
	
	/**
	 * �޸�
	 */
	public void update(T o);
	
	/**
	 * saveOrUpdate
	 */
	public void saveOrUpdate(T o);
	
	/**
	 * ��ȡ��������
	 */
	public T get(Serializable id);
	
	/**
	 * ��ȡ����
	 */
	public List<T> find(String hql);
	
	/**
	 * ��ȡ����
	 */
	public List<T> find(String hql, Map<String, Object> params);
	
	/**
	 * ��ȡ�����ҳ
	 */
	public List<T> find(String hql, int page, int rows);
	
	/**
	 * ��ȡ�����ҳ
	 */
	public List<T> find(String hql, Map<String, Object> params, int page, int rows);
	
	/**
	 * ��ȡ��¼����
	 */
	public Integer count(String hql);
	
	/**
	 * ��ȡ��¼����
	 */
	public Integer count(String hql, Integer id);
	
	/**
	 * ��ȡ��¼����
	 */
	public Integer count(String hql, Map<String, Object> params);
	
	/**
	 * һЩ�����DML����������޸�
	 */
	public int executeHql(String hql);
	
	/**
	 * һЩ�����DML����������޸�
	 */
	public int executeHql(String hql, Map<String, Object> params);
	
}
