package com.helloweenvsfei.petstore.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.helloweenvsfei.petstore.dialog.ViewCartDialog;
import com.helloweenvsfei.petstore.entity.UserEO;

public class ViewCartAction extends AbstractAction {

	private static final long serialVersionUID = 2807308033982942898L;

	private UserEO userEO;

	public ViewCartAction(UserEO userEO) {

		super("查看购物车");

		this.userEO = userEO;
	}

	public void actionPerformed(ActionEvent e) {

		ViewCartDialog dialog = new ViewCartDialog(userEO);

		dialog.setVisible(true);

	}

}
