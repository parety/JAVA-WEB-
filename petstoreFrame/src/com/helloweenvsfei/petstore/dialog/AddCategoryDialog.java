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
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.helloweenvsfei.petstore.entity.CategoryEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;
import com.helloweenvsfei.petstore.session.ICategory;
import com.helloweenvsfei.petstore.util.BOClient;
import com.helloweenvsfei.petstore.util.StringUtil;

public class AddCategoryDialog extends JDialog {

	private static final long serialVersionUID = -890023755317272521L;

	public static final int ACTION_ADD = 1;

	public static final int ACTION_EDIT = 2;

	/** 宠物类别树 */
	private JTree tree;

	private int action;

	private JTextField parentNameText, nameText;

	private JButton ok, cancel;

	/**
	 * @param tree1
	 * @param action1
	 */
	@SuppressWarnings("unchecked")
	public AddCategoryDialog(JTree tree1, int action1) {

		this.tree = tree1;
		this.action = action1;

		/** 被选中的节点所在的路径 */
		final Object[] selectedPath = tree.getSelectionPath().getPath();

		/** 被选中的节点 */
		final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath[selectedPath.length - 1];

		if (ACTION_ADD == action) {
			this.setTitle("添加新类别");
		} else {
			this.setTitle("修改类别");
		}

		parentNameText = new JTextField(25);
		nameText = new JTextField(25);

		ok = new JButton("OK");
		cancel = new JButton("Cancel");

		// this.setLayout(new GridLayout(4, 2));
		this.setLayout(new FlowLayout());

		this.add(new JLabel("上级类别："));
		this.add(parentNameText);

		this.add(new JLabel("类别名称："));
		this.add(nameText);

		this.add(ok);
		this.add(cancel);

		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setModal(true);
		this.setResizable(false);

		if (ACTION_ADD == action) {
			// 新建类别
			parentNameText.setText(selectedNode.toString());
			parentNameText.setEditable(false);

		} else if (ACTION_EDIT == action) {
			// 修改类别
			parentNameText.setText(selectedNode.getParent().toString());
			parentNameText.setEditable(false);

			nameText.setText(selectedNode.toString());
		}

		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (ACTION_ADD == action) {

					String catagoryName = nameText.getText().trim();
					String parentCategoryName = parentNameText.getText().trim();

					try {
						ICategory<CategoryEO> iCategory = (ICategory<CategoryEO>) BOClient
								.lookup("CategoryImpl/remote");

						CategoryEO categoryEO = new CategoryEO();
						categoryEO.setName(catagoryName);

						if (!parentCategoryName.equals("Petstore")) {
							categoryEO.setParent(iCategory
									.findCategory(parentCategoryName));
						}

						// 保存进数据库
						iCategory.createCategory(categoryEO);

						// 插入树节点
						((DefaultTreeModel) tree.getModel()).insertNodeInto(
								new DefaultMutableTreeNode(catagoryName),
								selectedNode, selectedNode.getChildCount());

						// 刷新当前树节点
						((DefaultTreeModel) tree.getModel())
								.reload(selectedNode);

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

				} else if (ACTION_EDIT == action) {

					String categoryName = nameText.getText().trim();
					// String parentCategoryName =
					// parentNameText.getText().trim();

					try {
						ICategory<CategoryEO> iCategory = (ICategory<CategoryEO>) BOClient
								.lookup("CategoryImpl/remote");

						// 查找
						CategoryEO categoryEO = iCategory
								.findCategory(selectedNode.toString());

						categoryEO.setName(categoryName);

						// 保存进数据库
						iCategory.saveCategory(categoryEO);

						// 修改当前树节点
						selectedNode.setUserObject(categoryName);

						// 刷新当前树节点
						((DefaultTreeModel) tree.getModel())
								.reload(selectedNode);

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
