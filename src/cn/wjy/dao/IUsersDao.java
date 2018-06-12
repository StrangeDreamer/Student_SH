package cn.wjy.dao;

import cn.wjy.enity.Users;

//用户业务逻辑接口
public interface IUsersDao {
	// 用户登录方法
	public boolean usersLogin(Users u);
}
