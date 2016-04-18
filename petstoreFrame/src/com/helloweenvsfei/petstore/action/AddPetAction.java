package com.helloweenvsfei.petstore.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;
import javax.swing.JTree;

import com.helloweenvsfei.petstore.dialog.AddPetDialog;

public class AddPetAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	private JTree tree;

	private JTable table;

	public AddPetAction(JTree tree, JTable table) {
		super("Ìí¼Ó³èÎï");
		this.tree = tree;
		this.table = table;
	}

	public void actionPerformed(ActionEvent e) {

		AddPetDialog dialog = new AddPetDialog(tree, table,
				AddPetDialog.ACTION_ADD);

		dialog.setVisible(true);

	}

}
