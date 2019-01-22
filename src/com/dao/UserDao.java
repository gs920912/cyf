package com.dao;

public interface UserDao<LUserInfo> extends BaseDao<LUserInfo> {
	
	/**
	 * 根据用户名和密码查找系统用户 对象
	 * @param username
	 * @param password
	 * @return
	 */
	public LUserInfo findByUserNameAndPwd(String username, String password);

}
