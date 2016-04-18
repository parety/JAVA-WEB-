package com.helloweenvsfei.petstore.web.action;

import org.apache.struts2.ServletActionContext;

import com.helloweenvsfei.petstore.entity.CategoryEO;
import com.helloweenvsfei.petstore.entity.PetEO;
import com.helloweenvsfei.petstore.entity.UserEO;
import com.helloweenvsfei.petstore.util.BOClient;
import com.helloweenvsfei.petstore.web.util.StringUtil;

public class PetAction extends BaseAction {

	private static final long serialVersionUID = 2794960245322824090L;

	public static final String ADD = "add";

	public static final String DELETE = "delete";

	public static final String BUY = "buy";

	private CategoryEO categoryEO;

	private PetEO petEO;

	private int count;

	public String execute() {

		if (ADD.equals(action))
			return add();

		if (DELETE.equals(action))
			return delete();

		if (BUY.equals(action))
			return buy();

		return add();
	}

	public String add() {

		setTitle("添加宠物");

		try {

			categoryEO = BOClient.lookupICategory().find(CategoryEO.class,
					categoryEO.getId());

		} catch (Exception e) {
			setMessage(e.getMessage());
			e.printStackTrace();
		}

		if (petEO == null) {
			return ADD;
		}

		if (StringUtil.isNull(petEO.getName())) {
			setMessage("请填写宠物名称");
			return ADD;
		}
		if (petEO.getPrice() <= 0) {
			setMessage("请填写价格");
			return ADD;
		}

		petEO.setCategory(categoryEO);

		try {
			BOClient.lookupIPet().createPet(petEO);
			setMessage(petEO.getName() + " 保存成功");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			setMessage(e.getMessage());
		}

		return ADD;
	}

	public String buy() {

		setTitle("购买宠物");

		UserEO userEO = (UserEO) ServletActionContext.getRequest().getSession(
				true).getAttribute("userEO");

		if (userEO == null) {
			setMessage("购买宠物需要登录");
			return LOGIN;
		}

		try {
			petEO = BOClient.lookupIPet().find(PetEO.class, petEO.getId());
		} catch (Exception e) {
			e.printStackTrace();
			setMessage(e.getMessage());
		}

		if (petEO == null || count == 0) {
			setCount(1);
			return BUY;
		}

		try {
			BOClient.lookupICart().addItem(userEO.getLogin(),
					petEO.getCategory().getName(), petEO.getName(),
					petEO.getPrice(), count);
			
			setMessage(petEO.getName() + "*" + count + " 购买成功");

			return "buySuccess";
		} catch (Exception e) {
			e.printStackTrace();
			setMessage(e.getMessage());
		}
		return BUY;
	}

	public String delete() {
		return DELETE;
	}

	public CategoryEO getCategoryEO() {
		return categoryEO;
	}

	public void setCategoryEO(CategoryEO categoryEO) {
		this.categoryEO = categoryEO;
	}

	public PetEO getPetEO() {
		return petEO;
	}

	public void setPetEO(PetEO petEO) {
		this.petEO = petEO;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
