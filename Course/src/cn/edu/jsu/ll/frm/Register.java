package cn.edu.jsu.ll.frm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.ll.dao.AthOperate_database;
import cn.edu.jsu.ll.dao.UserMatch;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField id;
	private JPasswordField pw;
	private JPasswordField pw1;
	private JDialog dialog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Register dialog = new Register();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Register() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
			lblNewLabel.setBounds(57, 55, 58, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
			lblNewLabel_1.setBounds(57, 93, 58, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			id = new JTextField();
			id.setBounds(158, 52, 140, 21);
			contentPanel.add(id);
			id.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("\u8BF7\u518D\u6B21\u8F93\u5165\uFF1A");
			lblNewLabel_2.setBounds(57, 135, 76, 15);
			contentPanel.add(lblNewLabel_2);
		}

		pw = new JPasswordField();
		pw.setBounds(158, 90, 140, 21);
		contentPanel.add(pw);

		pw1 = new JPasswordField();
		pw1.setBounds(158, 132, 140, 21);
		contentPanel.add(pw1);

		JButton register = new JButton("\u6CE8\u518C");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "select *from [User] where id="+id.getText();
				if (!new UserMatch().getSelect(sql)) {
					if (pw.getText().matches(pw1.getText())) {
						AthOperate_database.add(id.getText(), pw.getText());
						JOptionPane.showMessageDialog(null, "注册成功");
						new Homepage().main(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "密码不一致");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "账号已经存在");
				}

			}
		});
		register.setBounds(162, 189, 97, 23);
		contentPanel.add(register);
	}
}
