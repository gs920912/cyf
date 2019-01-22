package com.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BaseDao;

/**
 * ʵ�ֳ��÷����Ļ�����ӿڵ�ʵ��
 * @author gs
 *
 * @param <T>
 */

@Repository("baseDao")
@SuppressWarnings("all")
@Transactional
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	private Class<T> clz;
	
	private Class<T> getClz(){
		if(clz == null){
			//��ȡ���͵�Class����,��ͨ�������ȡ��
			clz = ((Class<T>)
                    (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}

	@Override
	public Serializable save(T o) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().save(o);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		T o = this.get(id);
		this.getCurrentSession().delete(o);
	}

	@Override
	public void delete(T o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(o);
	}

	@Override
	public void update(T o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(o);
	}

	@Override
	public void saveOrUpdate(T o) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(o);
	}

	@Override
	public T get(Serializable id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().get(getClz(), id);
	}

	@Override
	public List<T> find(String hql) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		return q.list();
	}

	/**
	 * Map<String, Object> params  : key : �ֶ�����  Object : �ֶε�ֵ
	 * 
	 * params != null && !params.isEmpty() ��������ģ�
	 */
	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if(params != null && !params.isEmpty()){
			for(String key : params.keySet()){
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	@Override
	public List<T> find(String hql, int page, int rows) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1)*rows).setMaxResults(rows).list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if(params != null && !params.isEmpty()){
			for(String key : params.keySet()){
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult((page - 1)*rows).setMaxResults(rows).list();
	}

	@Override
	public Integer count(String hql) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		List cc = q.list();
		Long a = (Long) cc.get(0);
		return a.intValue();
	}

	@Override
	public Integer count(String hql, Integer id) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter(0, id);
		List cc = q.list();
		Long a = (Long) cc.get(0);
		return a.intValue();
	}

	@Override
	public Integer count(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if(params != null && !params.isEmpty()){
			for(String key : params.keySet()){
				q.setParameter(key, params.get(key));
			}
		}
		return (Integer)q.uniqueResult();
	}

	@Override
	public int executeHql(String hql) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		// TODO Auto-generated method stub
		Query q = this.getCurrentSession().createQuery(hql);
		if(params != null && !params.isEmpty()){
			for(String key : params.keySet()){
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

}
