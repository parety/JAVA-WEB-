package com.helloweenvsfei.petstore.web.action;

import java.util.List;

import com.helloweenvsfei.petstore.entity.CategoryEO;
import com.helloweenvsfei.petstore.entity.PetEO;
import com.helloweenvsfei.petstore.util.BOClient;
import com.helloweenvsfei.petstore.web.util.StringUtil;

public class CategoryAction extends BaseAction {

	private static final long serialVersionUID = -6297389845292982094L;

	public static final String ADD = "add";

	public static final String DELETE = "delete";

	public static final String LIST = "list";

	private CategoryEO parent;

	private CategoryEO categoryEO;

	private List<PetEO> petEOList;

	public String execute() {
		if (ADD.equals(action)) {
			return add();
		}
		if (DELETE.equals(action)) {
			return delete();
		}
		return list();
	}

	public String add() {

		setTitle("添加宠物类别");

		if (parent != null)
			try {
				parent = BOClient.lookupICategory().find(CategoryEO.class,
						parent.getId());
			} catch (Exception e) {
				e.printStackTrace();
				parent = null;
			}

		if (categoryEO == null)
			return ADD;

		if (StringUtil.isNull(categoryEO.getName())) {
			setMessage("请填写类别名称");
			return ADD;
		}

		categoryEO.setParent(parent);

		try {
			BOClient.lookupICategory().createCategory(categoryEO);
			setMessage(categoryEO.getName() + " 保存成功");
			return SUCCESS;
		} catch (Exception e) {
			setMessage(e.getMessage());
			e.printStackTrace();
		}

		return ADD;
	}

	public String delete() {

		if (parent != null) {
			try {
				parent = BOClient.lookupICategory().find(CategoryEO.class,
						parent.getId());
				if (parent != null)
					BOClient.lookupICategory().deleteCategory(parent);
			} catch (Exception e) {
				setMessage(e.getMessage());
			}
		}

		setTitle("删除成功");
		setMessage("类别 " + parent.getName() + " 删除成功");

		return SUCCESS;
	}

	public String list() {

		setTitle("宠物列表");

		if (parent != null) {
			try {
				parent = BOClient.lookupICategory().find(CategoryEO.class,
						parent.getId());
			} catch (Exception e) {
				setMessage(e.getMessage());
			}
		}

		return LIST;
	}

	public List<PetEO> getPetEOList() {

		if (petEOList == null) {
			try {
				if (parent == null) {
					petEOList = BOClient.lookupIPet().list(" from PetEO p ");
				} else {
					petEOList = BOClient.lookupIPet().list(
							" from PetEO p where p.category.id = "
									+ parent.getId());
				}
			} catch (Exception e) {
				setMessage(e.getMessage());
				e.printStackTrace();
			}
		}

		return petEOList;
	}

	public CategoryEO getCategoryEO() {
		return categoryEO;
	}

	public void setCategoryEO(CategoryEO categoryEO) {
		this.categoryEO = categoryEO;
	}

	public CategoryEO getParent() {
		return parent;
	}

	public void setParent(CategoryEO parent) {
		this.parent = parent;
	}

	public void setPetEOList(List<PetEO> petEOList) {
		this.petEOList = petEOList;
	}
}
