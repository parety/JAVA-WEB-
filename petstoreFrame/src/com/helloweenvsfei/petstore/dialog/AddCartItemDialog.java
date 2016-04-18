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

	/** ��ǰ�û� */
	private UserEO userEO;

	/** ��� */
	private JTextField petCategory;

	/** ������� */
	private JTextField petName;

	/** ��ǰ�۸� */
	private JTextField petPrice;

	/** �������� */
	private JTextField petCount;

	private JButton ok, cancel;

	public AddCartItemDialog(UserEO userEO1, final String categoryName,
			final String name, final double price, final int count, int action) {

		this.userEO = userEO1;

		this.setTitle("�������Ի���");

		this.setLayout(new FlowLayout());

		petCategory = new JTextField(25);
		petName = new JTextField(25);
		petPrice = new JTextField(25);
		petCount = new JTextField(25);

		ok = new JButton("OK");
		cancel = new JButton("Cancel");

		this.add(new JLabel("�������"));
		this.add(petCategory);
		petCategory.setText(categoryName);
		petCategory.setEditable(false);

		this.add(new JLabel("�������ƣ�"));
		this.add(petName);
		petName.setText(name);
		petName.setEditable(false);

		this.add(new JLabel("����۸�"));
		this.add(petPrice);
		petPrice.setText(Double.toString(price));
		petPrice.setEditable(false);

		this.add(new JLabel("����������"));
		this.add(petCount);
		petCount.setText(Integer.toString(count));

		this.add(ok);
		this.add(cancel);

		ok.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					/** ���� */
					ICart<CartEO> iCart = BOClient.lookupICart();

					iCart.addItem(userEO.getLogin(), categoryName, name, price,
							Integer.parseInt(petCount.getText()));

					JOptionPane.showMessageDialog(null, "���� " + name
							+ " �ɹ����뵽���Ĺ��ﳵ����");

					dispose();

				} catch (NamingException ne) {

					JOptionPane
							.showMessageDialog(null, StringUtil.breakString(ne
									.getMessage()
									+ "\r\n\r\n�������� EJB3 ������", 50), "������������"
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
