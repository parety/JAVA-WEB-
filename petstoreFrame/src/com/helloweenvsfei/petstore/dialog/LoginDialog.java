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

	/** 用户名 */
	private String login;

	/** 分页控件 */
	private JTabbedPane tabbedPane;

	/** 登录页，注册页 */
	private JPanel loginPanel, registerPanel;

	/** 登录框，密码框 */
	private JTextField loginText, passwordText;

	/** 注册框，注册密码框，确认密码框 */
	private JTextField registerLoginText, registerPasswordText,
			confirmPasswordText;

	/** 登录按键 */
	private JButton loginOk, loginCancel;

	/** 注册按键 */
	private JButton registerOk, registerCancel;

	public LoginDialog() {

		this.setTitle("登陆对话框");

		tabbedPane = new JTabbedPane();

		loginPanel = new JPanel();
		registerPanel = new JPanel();

		initLoginPanel();

		initRegisterPanel();

		tabbedPane.add("登录", loginPanel);
		tabbedPane.add("申请", registerPanel);

		this.add(tabbedPane);

		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setModal(false);
		this.setResizable(false);

		this.setLocationByPlatform(true);

		loginOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					/** 获取 IUser 组件 */
					IUser<UserEO> iUser = BOClient.lookupIUser();
					/** 调用 IUser 组件方法 */
					UserEO userEO = iUser.findUser(loginText.getText(),
							passwordText.getText());

					/** 如果没有找到相应的记录，则抛出异常 */
					if (userEO == null) {
						throw new PetstoreException("用户名密码错误");
					}

					/** 如果正确，则显示主购物窗体 */
					PetstoreFrame petstoreFrame = new PetstoreFrame(userEO);
					petstoreFrame.setVisible(true);
					
					/** 登陆对话框隐掉 */
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
		loginCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		registerOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					if (registerLoginText.getText().trim().length() == 0) {

						throw new PetstoreException("请填写用户名");
					}

					if (registerPasswordText.getText().length() == 0) {

						throw new PetstoreException("请填写密码");
					}

					if (!registerPasswordText.getText().equals(
							confirmPasswordText.getText())) {

						throw new PetstoreException("两次密码不一致。");
					}

					IUser<UserEO> iUser = BOClient.lookupIUser();

					UserEO userEO = new UserEO();

					userEO.setLogin(registerLoginText.getText().toLowerCase()
							.trim());

					userEO.setPassword(registerPasswordText.getText());

					iUser.createUser(userEO);

					if (JOptionPane.YES_OPTION == JOptionPane
							.showConfirmDialog(null, "注册成功, 登录帐号为 "
									+ userEO.getLogin() + ". 是否直接登录？", "注册成功",
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

		registerOk = new JButton("申请");
		registerCancel = new JButton("取消");

		registerPanel.add(new JLabel("申请帐号："));
		registerPanel.add(registerLoginText);

		registerPanel.add(new JLabel("申请密码："));
		registerPanel.add(registerPasswordText);

		registerPanel.add(new JLabel("确认密码："));
		registerPanel.add(confirmPasswordText);

		registerPanel.add(registerOk);
		registerPanel.add(registerCancel);
	}

	private void initLoginPanel() {

		loginText = new JTextField(25);
		passwordText = new JPasswordField(25);

		loginText.setText("petstore_test");
		passwordText.setText("petstore_test");

		loginOk = new JButton("登录");
		loginCancel = new JButton("取消");

		loginPanel.add(new JLabel("登录帐号："));
		loginPanel.add(loginText);

		loginPanel.add(new JLabel("登录密码："));
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
