package com.helloweenvsfei.petstore.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTree;

import com.helloweenvsfei.petstore.dialog.AddCategoryDialog;

public class EditCategoryAction extends AbstractAction {

	private static final long serialVersionUID = 7733946061818666077L;

	private JTree tree;

	public EditCategoryAction(JTree tree) {

		super("±à¼­Àà±ð");

		this.tree = tree;
	}

	public void actionPerformed(ActionEvent e) {

		AddCategoryDialog dialog = new AddCategoryDialog(tree,
				AddCategoryDialog.ACTION_EDIT);

		dialog.setVisible(true);

	}

}
