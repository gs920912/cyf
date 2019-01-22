package com.dao.impl;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
@Repository("UserDao")
@Transactional
public class UserDaoImpl<LUserInfo> extends BaseDaoImpl<LUserInfo> implements UserDao<LUserInfo> {

	@Override
	public LUserInfo findByUserNameAndPwd(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "from LUserInfo a where a.username=? and a.password = ?";
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter(0, username);
		q.setParameter(1, password);
		return (LUserInfo) q.uniqueResult();
	}

	

}
