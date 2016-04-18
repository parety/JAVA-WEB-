package com.helloweenvsfei.petstore.dialog;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.helloweenvsfei.petstore.action.AddCategoryAction;
import com.helloweenvsfei.petstore.action.AddPetAction;
import com.helloweenvsfei.petstore.action.EditCategoryAction;
import com.helloweenvsfei.petstore.action.RemoveCategoryAction;
import com.helloweenvsfei.petstore.action.ViewCartAction;
import com.helloweenvsfei.petstore.entity.CategoryEO;
import com.helloweenvsfei.petstore.entity.PetEO;
import com.helloweenvsfei.petstore.entity.UserEO;
import com.helloweenvsfei.petstore.model.PetTableModel;
import com.helloweenvsfei.petstore.session.ICategory;
import com.helloweenvsfei.petstore.session.IPet;
import com.helloweenvsfei.petstore.util.BOClient;
import com.helloweenvsfei.petstore.util.StringUtil;

/**
 * CREATE DATABASE databaseWeb CHARACTER SET utf8
 * 
 * @author Helloween
 * 
 */
public class PetstoreFrame extends JFrame {

	private static final long serialVersionUID = 5969865890684778145L;

	/** 当前登录的用户 */
	private UserEO userEO;

	/** EJB3 组件 */
	public ICategory<CategoryEO> iCategory;

	public IPet<PetEO> iPet;

	/** 左侧宠物类别树 */
	public JTree tree;

	/** 右侧宠物列表 */
	public JTable table;

	/** 工具栏 菜单 状态栏命令 */
	private AddCategoryAction addCategoryAction;

	private EditCategoryAction editCategoryAction;

	private RemoveCategoryAction removeCategoryAction;

	private AddPetAction addPetAction;

	private ViewCartAction viewCartAction;

	@SuppressWarnings("unchecked")
	public PetstoreFrame(UserEO userEO) {

		this.userEO = userEO;

		try {
			// 通过名称查找
			iCategory = (ICategory<CategoryEO>) BOClient
					.lookup("CategoryImpl/remote");

			// 静态方法查找
			iPet = BOClient.lookupIPet();

		} catch (NamingException e) {

			JOptionPane.showMessageDialog(null, StringUtil.breakString(e
					.getMessage()
					+ "\r\n\r\n请先启动 EJB3 容器。", 50), "程序启动错误：" + e.getClass(),
					JOptionPane.ERROR_MESSAGE);

			return;
		}

		this.setTitle("宠物商店客户端");
		this.setLayout(new BorderLayout());

		// initCatalog();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		// 设置 splitPane 的分隔线位置
		splitPane.setDividerLocation(200);
		// 设置 splitPane 是否可以展开或收起
		splitPane.setOneTouchExpandable(true);
		// 设置 splitPane 分隔线宽度
		splitPane.setDividerSize(10);

		this.add(splitPane, BorderLayout.CENTER);

		/** 初始化左侧宠物类别树 */
		initLeftPane(splitPane);
		/** 初始化右侧宠物列表 */
		initRightPane(splitPane);

		/** 初始化 工具栏 菜单 状态 命令 */
		initActions();

		/** 初始化工具栏 */
		JToolBar toolbar = new JToolBar();
		toolbar.add(addCategoryAction);
		toolbar.add(addPetAction);
		toolbar.add(viewCartAction);
		this.add(toolbar, BorderLayout.NORTH);

		/** 初始化状态栏 */
		JToolBar statusbar = new JToolBar();
		statusbar.add(addCategoryAction);
		statusbar.add(editCategoryAction);
		statusbar.add(removeCategoryAction);
		statusbar.add(addPetAction);
		statusbar.add(viewCartAction);
		this.add(statusbar, BorderLayout.SOUTH);

		/** 初始化宠物类别树的右键菜单 */
		final JPopupMenu popup = new JPopupMenu();
		popup.add(addCategoryAction);
		popup.add(editCategoryAction);
		popup.add(removeCategoryAction);
		popup.addSeparator();
		popup.add(addPetAction);

		tree.add(popup);
		tree.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				/** 如果是右键事件，则显示右键菜单 */
				if (e.isPopupTrigger()) {
					popup.show(tree, e.getX(), e.getY());
				}
			}
		});

		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	private void initLeftPane(JSplitPane splitPane) {

		/** 数根节点 */
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Petstore");

		tree = new JTree(rootNode);

		/** 如果选择了树的其他节点,则触发事件 */
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				if (e.getNewLeadSelectionPath() == null
						|| e.getNewLeadSelectionPath().getLastPathComponent() == null) {

					addCategoryAction.setEnabled(false);
					editCategoryAction.setEnabled(false);
					removeCategoryAction.setEnabled(false);
					addPetAction.setEnabled(false);

					return;

				} else {

					addCategoryAction.setEnabled(true);
					editCategoryAction.setEnabled(true);
					removeCategoryAction.setEnabled(true);
					addPetAction.setEnabled(true);

					DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
							.getNewLeadSelectionPath().getLastPathComponent();

					if (node.toString().equals("Petstore")) {
						editCategoryAction.setEnabled(false);
						removeCategoryAction.setEnabled(false);
						addPetAction.setEnabled(false);
					}

					/** 刷新右侧的宠物列表 */
					List petList = iCategory
							.list(" from PetEO p where p.category.name = '"
									+ (String) node.getUserObject() + "'");

					((PetTableModel) table.getModel()).setList(petList);

					table.repaint();
					table.getParent().doLayout();
				}
			}
		});

		splitPane.setLeftComponent(new JScrollPane(tree));

		initRootNode(rootNode);

	}

	protected void initActions() {

		addCategoryAction = new AddCategoryAction(tree);
		editCategoryAction = new EditCategoryAction(tree);
		removeCategoryAction = new RemoveCategoryAction(tree);

		addPetAction = new AddPetAction(tree, table);

		viewCartAction = new ViewCartAction(userEO);

		addCategoryAction.setEnabled(false);
		editCategoryAction.setEnabled(false);
		removeCategoryAction.setEnabled(false);

		addPetAction.setEnabled(false);
	}

	/** 初始化根节点, 从数据库中读取子节点数据 */
	@SuppressWarnings("unchecked")
	protected void initRootNode(DefaultMutableTreeNode rootNode) {
		rootNode.removeAllChildren();
		List<CategoryEO> nodeList = iCategory
				.list(" from CategoryEO c where c.parent = null ");
		for (int i = 0; i < nodeList.size(); i++) {
			CategoryEO catalog = nodeList.get(i);
			initSubNode(rootNode, catalog);
		}
	}

	/** 初始化非根节点, 从数据库读取子节点数据 */
	@SuppressWarnings("unchecked")
	private void initSubNode(DefaultMutableTreeNode node, CategoryEO catalog) {

		DefaultMutableTreeNode subNode = new DefaultMutableTreeNode(catalog
				.getName());

		node.insert(subNode, node.getChildCount());

		for (Iterator<CategoryEO> it = catalog.getSubCategories().iterator(); it
				.hasNext();) {
			CategoryEO subCatalog = it.next();
			initSubNode(subNode, subCatalog);
		}
	}

	/** 初始化右侧宠物列表 */
	private void initRightPane(JSplitPane splitPane) {

		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout());

		table = new JTable(new PetTableModel());
		table.addMouseListener(new MouseAdapter() {

			/** 如果双击表格, 则打开 宠物购买窗口 */
			@Override
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {

					/** 选中的行号 */
					int rowIndex = table.getSelectedRow();

					if (rowIndex >= 0) {

						String petCategory = (String) table.getModel()
								.getValueAt(rowIndex, 2);

						String petName = (String) table.getModel().getValueAt(
								rowIndex, 1);

						double price = (Double) table.getModel().getValueAt(
								rowIndex, 3);

						/** 宠物购买窗口 */
						AddCartItemDialog dialog = new AddCartItemDialog(
								userEO, petCategory, petName, price, 1,
								AddCartItemDialog.ACTION_ADD);

						dialog.setVisible(true);

					}
				}
			}
		});

		splitPane.setRightComponent(panel);

		panel.add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public UserEO getUserEO() {
		return userEO;
	}

	public void setUserEO(UserEO userEO) {
		this.userEO = userEO;
	}

}
