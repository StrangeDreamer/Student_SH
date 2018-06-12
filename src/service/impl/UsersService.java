package service.impl;

import service.IUsersService;
import cn.wjy.dao.IUsersDao;
import cn.wjy.dao.impl.UsersDao;
import cn.wjy.enity.Users;

public class UsersService implements IUsersService {

	private IUsersDao usersDao = new UsersDao();

	@Override
	public boolean usersLogin(Users u) {
		return usersDao.usersLogin(u);
	}

}
