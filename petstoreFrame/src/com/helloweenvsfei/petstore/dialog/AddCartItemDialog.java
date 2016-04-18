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

import com.helloweenvsfei.petstore.entity.CartEO;
import com.helloweenvsfei.petstore.entity.UserEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;
import com.helloweenvsfei.petstore.session.ICart;
import com.helloweenvsfei.petstore.util.BOClient;
import com.helloweenvsfei.petstore.util.StringUtil;

public class AddCartItemDialog extends JDialog {

	private static final long serialVersionUID = 1657499908756571537L;

	public static final int ACTION_ADD = 1;

	public static final int ACTION_EDIT = 2;

	/** 当前用户 */
	private UserEO userEO;

	/** 类别 */
	private JTextField petCategory;

	/** 宠物类别 */
	private JTextField petName;

	/** 当前价格 */
	private JTextField petPrice;

	/** 购买数量 */
	private JTextField petCount;

	private JButton ok, cancel;

	public AddCartItemDialog(UserEO userEO1, final String categoryName,
			final String name, final double price, final int count, int action) {

		this.userEO = userEO1;

		this.setTitle("购买宠物对话框");

		this.setLayout(new FlowLayout());

		petCategory = new JTextField(25);
		petName = new JTextField(25);
		petPrice = new JTextField(25);
		petCount = new JTextField(25);

		ok = new JButton("OK");
		cancel = new JButton("Cancel");

		this.add(new JLabel("宠物类别："));
		this.add(petCategory);
		petCategory.setText(categoryName);
		petCategory.setEditable(false);

		this.add(new JLabel("宠物名称："));
		this.add(petName);
		petName.setText(name);
		petName.setEditable(false);

		this.add(new JLabel("宠物价格："));
		this.add(petPrice);
		petPrice.setText(Double.toString(price));
		petPrice.setEditable(false);

		this.add(new JLabel("宠物数量："));
		this.add(petCount);
		petCount.setText(Integer.toString(count));

		this.add(ok);
		this.add(cancel);

		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					/** 购买 */
					ICart<CartEO> iCart = BOClient.lookupICart();

					iCart.addItem(userEO.getLogin(), categoryName, name, price,
							Integer.parseInt(petCount.getText()));

					JOptionPane.showMessageDialog(null, "宠物 " + name
							+ " 成功加入到您的购物车中了");

					dispose();

				} catch (NamingException ne) {

					JOptionPane
							.showMessageDialog(null, StringUtil.breakString(ne
									.getMessage()
									+ "\r\n\r\n请先启动 EJB3 容器。", 50), "程序启动错误："
									+ e.getClass(), JOptionPane.ERROR_MESSAGE);

					return;

				} catch (PetstoreException ex) {

					JOptionPane.showMessageDialog(null, ex.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);

					return;
				}

			}
		});

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setModal(true);
		this.setResizable(false);

	}

}
