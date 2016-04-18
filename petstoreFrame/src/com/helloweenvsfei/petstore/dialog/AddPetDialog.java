package com.helloweenvsfei.petstore.dialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.helloweenvsfei.petstore.entity.CategoryEO;
import com.helloweenvsfei.petstore.entity.PetEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;
import com.helloweenvsfei.petstore.model.PetTableModel;
import com.helloweenvsfei.petstore.session.ICategory;
import com.helloweenvsfei.petstore.session.IPet;
import com.helloweenvsfei.petstore.util.BOClient;
import com.helloweenvsfei.petstore.util.StringUtil;

public class AddPetDialog extends JDialog {

	private static final long serialVersionUID = 1413262482151305501L;

	public static final int ACTION_ADD = 1;

	public static final int ACTION_EDIT = 2;

	private int action;

	/** 宠物类别数 */
	private JTree tree;

	/** 宠物类别列表 */
	private JTable table;

	/**  */
	private JTextField petName, categoryName, price;

	private JButton ok, cancel;

	@SuppressWarnings("unchecked")
	public AddPetDialog(JTree tree1, JTable table1, int action1) {

		petName = new JTextField(25);
		categoryName = new JTextField(25);
		price = new JTextField(25);

		ok = new JButton("OK");
		cancel = new JButton("CANCEL");

		action = action1;
		tree = tree1;
		table = table1;

		final Object[] selectedPath = tree.getSelectionPath().getPath();

		final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath[selectedPath.length - 1];

		if (action == ACTION_ADD) {
			this.setTitle("添加宠物");
		} else if (action == ACTION_EDIT) {
			this.setTitle("修改宠物");
		}

		this.setLayout(new FlowLayout());

		this.add(new JLabel("宠物类别："));
		this.add(categoryName);

		this.add(new JLabel("宠物名称："));
		this.add(petName);

		this.add(new JLabel("宠物价格："));
		this.add(price);

		this.add(ok);
		this.add(cancel);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setSize(400, 300);
		this.setModal(true);
		this.setResizable(false);

		if (action == ACTION_ADD) {

			categoryName.setText(selectedNode.toString());
			categoryName.setEditable(false);

		} else if (action == ACTION_EDIT) {

		}

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (action == ACTION_ADD) {

					try {
						IPet<PetEO> pet = BOClient.lookupIPet();
						ICategory<CategoryEO> category = BOClient
								.lookupICategory();

						CategoryEO catagoryEO = category
								.findCategory(categoryName.getText());

						PetEO petEO = new PetEO();
						petEO.setCategory(catagoryEO);
						petEO.setName(petName.getText());
						petEO.setPrice(new Double(price.getText()));

						petEO = pet.createPet(petEO);

						((PetTableModel) table.getModel()).getList().add(petEO);

						table.getParent().doLayout();

					} catch (NamingException ne) {

						JOptionPane.showMessageDialog(null, "获取 JNDI 异常",
								StringUtil.breakString(ne.toString(), 30),
								JOptionPane.ERROR_MESSAGE);

						return;

					} catch (PetstoreException ex) {

						JOptionPane.showMessageDialog(null, ex.getMessage(),
								"Error", JOptionPane.ERROR_MESSAGE);

						return;
					}

				} else if (action == ACTION_EDIT) {

				}

				dispose();
			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});

	}
}
