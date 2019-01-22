package com.dao;

public interface UserDao<LUserInfo> extends BaseDao<LUserInfo> {
	
	/**
	 * �����û������������ϵͳ�û� ����
	 * @param username
	 * @param password
	 * @return
	 */
	public LUserInfo findByUserNameAndPwd(String username, String password);

}
