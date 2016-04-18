package com.helloweenvsfei.petstore.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.helloweenvsfei.petstore.entity.UserEO;
import com.helloweenvsfei.petstore.exception.PetstoreException;
import com.helloweenvsfei.petstore.session.IUser;
import com.helloweenvsfei.petstore.util.BOClient;
import com.helloweenvsfei.petstore.util.StringUtil;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 7055798624294918986L;

	/** �û��� */
	private String login;

	/** ��ҳ�ؼ� */
	private JTabbedPane tabbedPane;

	/** ��¼ҳ��ע��ҳ */
	private JPanel loginPanel, registerPanel;

	/** ��¼������� */
	private JTextField loginText, passwordText;

	/** ע���ע�������ȷ������� */
	private JTextField registerLoginText, registerPasswordText,
			confirmPasswordText;

	/** ��¼���� */
	private JButton loginOk, loginCancel;

	/** ע�ᰴ�� */
	private JButton registerOk, registerCancel;

	public LoginDialog() {

		this.setTitle("��½�Ի���");

		tabbedPane = new JTabbedPane();

		loginPanel = new JPanel();
		registerPanel = new JPanel();

		initLoginPanel();

		initRegisterPanel();

		tabbedPane.add("��¼", loginPanel);
		tabbedPane.add("����", registerPanel);

		this.add(tabbedPane);

		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setModal(false);
		this.setResizable(false);

		this.setLocationByPlatform(true);

		loginOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					/** ��ȡ IUser ��� */
					IUser<UserEO> iUser = BOClient.lookupIUser();
					/** ���� IUser ������� */
					UserEO userEO = iUser.findUser(loginText.getText(),
							passwordText.getText());

					/** ���û���ҵ���Ӧ�ļ�¼�����׳��쳣 */
					if (userEO == null) {
						throw new PetstoreException("�û����������");
					}

					/** �����ȷ������ʾ�����ﴰ�� */
					PetstoreFrame petstoreFrame = new PetstoreFrame(userEO);
					petstoreFrame.setVisible(true);
					
					/** ��½�Ի������� */
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
		loginCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		registerOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					if (registerLoginText.getText().trim().length() == 0) {

						throw new PetstoreException("����д�û���");
					}

					if (registerPasswordText.getText().length() == 0) {

						throw new PetstoreException("����д����");
					}

					if (!registerPasswordText.getText().equals(
							confirmPasswordText.getText())) {

						throw new PetstoreException("�������벻һ�¡�");
					}

					IUser<UserEO> iUser = BOClient.lookupIUser();

					UserEO userEO = new UserEO();

					userEO.setLogin(registerLoginText.getText().toLowerCase()
							.trim());

					userEO.setPassword(registerPasswordText.getText());

					iUser.createUser(userEO);

					if (JOptionPane.YES_OPTION == JOptionPane
							.showConfirmDialog(null, "ע��ɹ�, ��¼�ʺ�Ϊ "
									+ userEO.getLogin() + ". �Ƿ�ֱ�ӵ�¼��", "ע��ɹ�",
									JOptionPane.YES_NO_OPTION)) {

						PetstoreFrame petstoreFrame = new PetstoreFrame(userEO);
						petstoreFrame.setVisible(true);

						dispose();

					} else {
						registerLoginText.setText("");
						registerPasswordText.setText("");
						confirmPasswordText.setText("");

						loginText.setText(userEO.getLogin());
						passwordText.setText(userEO.getPassword());

						tabbedPane.setSelectedIndex(0);
					}

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
		registerCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	private void initRegisterPanel() {

		registerLoginText = new JTextField(25);
		registerPasswordText = new JPasswordField(25);
		confirmPasswordText = new JPasswordField(25);

		registerOk = new JButton("����");
		registerCancel = new JButton("ȡ��");

		registerPanel.add(new JLabel("�����ʺţ�"));
		registerPanel.add(registerLoginText);

		registerPanel.add(new JLabel("�������룺"));
		registerPanel.add(registerPasswordText);

		registerPanel.add(new JLabel("ȷ�����룺"));
		registerPanel.add(confirmPasswordText);

		registerPanel.add(registerOk);
		registerPanel.add(registerCancel);
	}

	private void initLoginPanel() {

		loginText = new JTextField(25);
		passwordText = new JPasswordField(25);

		loginText.setText("petstore_test");
		passwordText.setText("petstore_test");

		loginOk = new JButton("��¼");
		loginCancel = new JButton("ȡ��");

		loginPanel.add(new JLabel("��¼�ʺţ�"));
		loginPanel.add(loginText);

		loginPanel.add(new JLabel("��¼���룺"));
		loginPanel.add(passwordText);

		loginPanel.add(loginOk);
		loginPanel.add(loginCancel);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
