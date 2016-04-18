package com.helloweenvsfei.petstore.web.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.helloweenvsfei.petstore.entity.UserEO;
import com.helloweenvsfei.petstore.util.BOClient;
import com.helloweenvsfei.petstore.web.util.StringUtil;

public class UserAction extends BaseAction {

	private static final long serialVersionUID = 2683928407831291840L;

	public static final String REGISTER = "register";

	public static final String LOGOUT = "logout";

	private UserEO userEO;

	private String confirmPassword;

	public String execute() {
		if (REGISTER.equals(action))
			return register();
		if (LOGIN.equals(action))
			return login();
		if (LOGOUT.equals(action))
			return logout();
		return login();
	}

	public String register() {

		setTitle("用户注册");

		if (userEO == null) {
			return REGISTER;
		}
		if (StringUtil.isNull(userEO.getLogin())
				|| StringUtil.isNull(userEO.getPassword())) {
			setMessage("请填写注册信息");
			return REGISTER;
		}
		if (!userEO.getPassword().equals(confirmPassword)) {
			setMessage("密码不一致");
			return REGISTER;
		}

		try {
			userEO = BOClient.lookupIUser().createUser(userEO);

			HttpSession session = ServletActionContext.getRequest().getSession(
					true);

			session.setAttribute("userEO", userEO);

			setMessage("注册成功");

			return SUCCESS;

		} catch (Exception e) {
			setMessage("发生错误：" + e.getMessage());
		}

		return REGISTER;
	}

	public String login() {

		setTitle("用户登录");

		if (userEO == null)
			return LOGIN;
		if (StringUtil.isNull(userEO.getLogin())
				|| StringUtil.isNull(userEO.getPassword())) {
			setMessage("请输入账号密码");
			return LOGIN;
		}

		try {
			UserEO user = BOClient.lookupIUser().findUser(userEO.getLogin(),
					userEO.getPassword());

			if (user == null) {
				setMessage("用户名密码错误");
				return LOGIN;
			} else {
				HttpSession session = ServletActionContext.getRequest()
						.getSession(true);
				session.setAttribute("userEO", user);
				setMessage("欢迎回来，" + user.getLogin());
				return SUCCESS;
			}

		} catch (Exception e) {
			setMessage("发生错误：" + e.getMessage());
		}

		return LOGIN;
	}

	public String logout() {

		HttpSession session = ServletActionContext.getRequest()
				.getSession(true);
		session.setAttribute("userEO", null);

		setMessage("注销成功");

		return login();
	}

	public UserEO getUserEO() {
		return userEO;
	}

	public void setUserEO(UserEO userEO) {
		this.userEO = userEO;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
