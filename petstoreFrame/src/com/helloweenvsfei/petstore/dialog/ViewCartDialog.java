package com.helloweenvsfei.petstore.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.helloweenvsfei.petstore.entity.CartEO;
import com.helloweenvsfei.petstore.entity.CartItemEO;
import com.helloweenvsfei.petstore.entity.UserEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;
import com.helloweenvsfei.petstore.model.CartTableModel;
import com.helloweenvsfei.petstore.session.ICart;
import com.helloweenvsfei.petstore.util.BOClient;
import com.helloweenvsfei.petstore.util.StringUtil;

public class ViewCartDialog extends JDialog {

	private static final long serialVersionUID = -3438247131881841618L;

	/** 当前用户 */
	private UserEO userEO;

	/** 购物车 */
	private CartEO cartEO;

	/** 购物车内的宠物列表 */
	private JTable table;

	private JPanel top;

	/** 付款按钮 */
	private JButton payButton;

	private JLabel payInfo;

	public ViewCartDialog(UserEO userEO1) {

		this.userEO = userEO1;

		table = new JTable(new CartTableModel());
		top = new JPanel();

		payButton = new JButton("付款");
		payInfo = new JLabel();

		this.add(top, BorderLayout.NORTH);
		this.add(new JScrollPane(table), BorderLayout.CENTER);

		top.setLayout(new FlowLayout());

		top.add(payInfo);
		top.add(payButton);

		payInfo.setText("sdf sdf asdf asdflk asdkl S");

		this.setTitle("View Cart Dialog");

		this.setSize(500, 350);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setModal(true);
		this.setResizable(false);

		payButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					if (cartEO.getCartItems().size() == 0) {

						throw new PetstoreException("购物车内没有商品，无需付款");
					}

					ICart<CartEO> iCart = BOClient.lookupICart();

					cartEO.setPayed(true);

					iCart.payCart(cartEO);

					init();

				} catch (NamingException ne) {

					JOptionPane.showMessageDialog(null, StringUtil.breakString(
							ne.getMessage() + "\r\n\r\n请先启动 EJB3 容器。", 50),
							"程序启动错误：" + ne.getClass(),
							JOptionPane.ERROR_MESSAGE);

					return;

				} catch (PetstoreException ex) {

					JOptionPane.showMessageDialog(null, ex.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);

					return;
				}

			}
		});

		try {

			ICart<CartEO> iCart = BOClient.lookupICart();

			cartEO = iCart.findCart(userEO.getLogin());

		} catch (NamingException ne) {

			JOptionPane.showMessageDialog(null, StringUtil.breakString(ne
					.getMessage()
					+ "\r\n\r\n请先启动 EJB3 容器。", 50), "程序启动错误：" + ne.getClass(),
					JOptionPane.ERROR_MESSAGE);

			return;

		} catch (PetstoreException ex) {

			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);

			return;
		}

		init();

	}

	private void init() {

		List<CartItemEO> list = new ArrayList<CartItemEO>();

		double totalPrice = 0d;

		/** 遍历购物车内的所有的宠物, 并计算总价格 */
		for (CartItemEO cartItemEO : cartEO.getCartItems()) {

			list.add(cartItemEO);

			totalPrice += cartItemEO.getCount() * cartItemEO.getPrice();

		}

		/** 设置 JTable Model 的数据 */
		((CartTableModel) table.getModel()).setList(list);

		/** 刷新表格 */
		table.getParent().doLayout();

		if (cartEO.isPayed()) {

			payInfo.setText("购买者：" + userEO.getLogin() + ", 总价格为：￥"
					+ totalPrice + ", 已经付款。");

			payButton.setEnabled(false);

		} else {

			payInfo.setText("购买者：" + userEO.getLogin() + ", 总价格为：￥"
					+ totalPrice + ", 尚未付款。");

			payButton.setEnabled(true);
		}

	}

}
