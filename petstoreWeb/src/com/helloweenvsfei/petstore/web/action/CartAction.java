package com.helloweenvsfei.petstore.web.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.helloweenvsfei.petstore.entity.CartEO;
import com.helloweenvsfei.petstore.entity.UserEO;
import com.helloweenvsfei.petstore.util.BOClient;

public class CartAction extends BaseAction {

	private static final long serialVersionUID = -460689916730173338L;

	public static final String LIST = "list";

	public static final String PAY = "pay";

	private CartEO cartEO;

	public String execute() {

		HttpSession session = ServletActionContext.getRequest()
				.getSession(true);

		UserEO userEO = (UserEO) session.getAttribute("userEO");

		if (userEO == null) {
			setMessage("您还没有登录");
			return LOGIN;
		}

		if (PAY.equals(action))
			return pay();

		return LIST;
	}

	public String pay() {

		try {
			BOClient.lookupICart().payCart(getCartEO());
			setMessage("感谢您购买宠物！");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			setMessage(e.getMessage());
		}

		return LIST;
	}

	public CartEO getCartEO() {

		if (cartEO == null) {

			try {
				HttpSession session = ServletActionContext.getRequest()
						.getSession(true);
				UserEO userEO = (UserEO) session.getAttribute("userEO");

				cartEO = BOClient.lookupICart().findCart(userEO.getLogin());
			} catch (Exception e) {
				setMessage(e.getMessage());
			}

		}

		return cartEO;
	}

	public void setCartEO(CartEO cartEO) {
		this.cartEO = cartEO;
	}

}
