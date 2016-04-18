package com.helloweenvsfei.petstore.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTree;

import com.helloweenvsfei.petstore.dialog.AddCategoryDialog;

public class AddCategoryAction extends AbstractAction {

	private static final long serialVersionUID = 7892089739549627978L;

	private JTree tree;

	public AddCategoryAction(JTree tree) {

		super("Ìí¼ÓÀà±ð");

		this.tree = tree;

	}

	public void actionPerformed(ActionEvent e) {

		AddCategoryDialog dialog = new AddCategoryDialog(tree,
				AddCategoryDialog.ACTION_ADD);

		dialog.setVisible(true);

	}
}
