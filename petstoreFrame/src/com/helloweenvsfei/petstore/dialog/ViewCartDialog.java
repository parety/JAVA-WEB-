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

	/** ��ǰ�û� */
	private UserEO userEO;

	/** ���ﳵ */
	private CartEO cartEO;

	/** ���ﳵ�ڵĳ����б� */
	private JTable table;

	private JPanel top;

	/** ���ť */
	private JButton payButton;

	private JLabel payInfo;

	public ViewCartDialog(UserEO userEO1) {

		this.userEO = userEO1;

		table = new JTable(new CartTableModel());
		top = new JPanel();

		payButton = new JButton("����");
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

						throw new PetstoreException("���ﳵ��û����Ʒ�����踶��");
					}

					ICart<CartEO> iCart = BOClient.lookupICart();

					cartEO.setPayed(true);

					iCart.payCart(cartEO);

					init();

				} catch (NamingException ne) {

					JOptionPane.showMessageDialog(null, StringUtil.breakString(
							ne.getMessage() + "\r\n\r\n�������� EJB3 ������", 50),
							"������������" + ne.getClass(),
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
					+ "\r\n\r\n�������� EJB3 ������", 50), "������������" + ne.getClass(),
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

		/** �������ﳵ�ڵ����еĳ���, �������ܼ۸� */
		for (CartItemEO cartItemEO : cartEO.getCartItems()) {

			list.add(cartItemEO);

			totalPrice += cartItemEO.getCount() * cartItemEO.getPrice();

		}

		/** ���� JTable Model ������ */
		((CartTableModel) table.getModel()).setList(list);

		/** ˢ�±�� */
		table.getParent().doLayout();

		if (cartEO.isPayed()) {

			payInfo.setText("�����ߣ�" + userEO.getLogin() + ", �ܼ۸�Ϊ����"
					+ totalPrice + ", �Ѿ����");

			payButton.setEnabled(false);

		} else {

			payInfo.setText("�����ߣ�" + userEO.getLogin() + ", �ܼ۸�Ϊ����"
					+ totalPrice + ", ��δ���");

			payButton.setEnabled(true);
		}

	}

}
