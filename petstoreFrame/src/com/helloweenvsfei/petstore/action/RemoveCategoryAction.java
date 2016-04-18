package com.helloweenvsfei.petstore.action;

import java.awt.event.ActionEvent;

import javax.naming.NamingException;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import com.helloweenvsfei.petstore.entity.CategoryEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;
import com.helloweenvsfei.petstore.session.ICategory;
import com.helloweenvsfei.petstore.util.BOClient;
import com.helloweenvsfei.petstore.util.StringUtil;

public class RemoveCategoryAction extends AbstractAction {

	private static final long serialVersionUID = 7892089739549627978L;

	private JTree tree;

	public RemoveCategoryAction(JTree tree) {

		super("ɾ�����");

		this.tree = tree;

	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {

		final Object[] selectedPath = tree.getSelectionPath().getPath();

		final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath[selectedPath.length - 1];

		int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ����� "
				+ selectedNode + " ��", "ɾ��ȷ��", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.OK_OPTION) {

			try {
				ICategory<CategoryEO> iCategory = (ICategory<CategoryEO>) BOClient
						.lookup("CategoryImpl/remote");

				CategoryEO categoryEO = iCategory.findCategory(selectedNode
						.toString());

				iCategory.deleteCategory(categoryEO);

				TreeNode parentNode = selectedNode.getParent();

				// ɾ���ڵ�
				((DefaultTreeModel) tree.getModel())
						.removeNodeFromParent(selectedNode);

				((DefaultTreeModel) tree.getModel()).reload(parentNode);

			} catch (NamingException ne) {

				JOptionPane.showMessageDialog(null, "��ȡ JNDI �쳣", StringUtil
						.breakString(ne.toString(), 30),
						JOptionPane.ERROR_MESSAGE);

				return;

			} catch (PetstoreException ex) {

				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);

				return;
			}

		}

	}
}
