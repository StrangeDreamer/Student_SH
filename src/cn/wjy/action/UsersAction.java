package cn.wjy.action;

import service.IUsersService;
import service.impl.UsersService;
import cn.wjy.enity.Users;

import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends SuperAction implements ModelDriven<Users> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Users user = new Users();

	public String login() {
		session.setAttribute("loginUserName", user.getUsername());
		IUsersService userService = new UsersService();
		if (userService.usersLogin(user)) {
			return "login_success";
		} else {
			return "login_failure";
		}

	}

	public void validateLogin() {
		if ("".equals(user.getUsername().trim())) {
			this.addFieldError("usernameError", "用户名不能为空！");
		
		}
		if (user.getPassword().length() < 6) {
			this.addFieldError("passwordError", "密码不能小于6位!");
		
		}
	}

	public String logout() {
		if (session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}

	@Override
	public Users getModel() {
		return this.user;
	}

}
