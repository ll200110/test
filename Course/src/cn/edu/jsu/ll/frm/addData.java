package cn.edu.jsu.ll.frm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.ll.dao.AthOperate_txt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class addData extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField TXTid;
	private JTextField TXTPno;
	private JLabel lblid;
	private JLabel lblPno;
	private JLabel lblgrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			addData dialog = new addData();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setModal(true);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public addData() {
		setTitle("\u62A5\u540D");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 36, 51, 29);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u9879\u76EE\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 72, 83, 35);
		contentPanel.add(lblNewLabel_1);

		TXTid = new JTextField();
		TXTid.setBounds(121, 42, 128, 23);
		contentPanel.add(TXTid);
		TXTid.setColumns(10);

		TXTPno = new JTextField();
		TXTPno.setBounds(121, 79, 128, 26);
		contentPanel.add(TXTPno);
		TXTPno.setColumns(10);

		JButton addition = new JButton("\u62A5\u540D");
		addition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkid() && checkid()) {

					String stu = TXTid.getText() + "\t" + TXTPno.getText() +"\r\n";

					if (AthOperate_txt.addid(stu, TXTid.getText(),TXTPno.getText())) {

						JOptionPane.showMessageDialog(null, "报名成功");

						flush();

					} else {

						JOptionPane.showMessageDialog(null, "此学号已存在");

						flush();

					}

				}
			}
		});
		addition.setBounds(134, 133, 97, 23);
		contentPanel.add(addition);

		JLabel lblid = new JLabel("");
		lblid.setForeground(Color.RED);
		lblid.setBounds(295, 45, 114, 23);
		contentPanel.add(lblid);

		JLabel lblPno = new JLabel("");
		lblPno.setForeground(Color.RED);
		lblPno.setBounds(295, 84, 114, 23);
		contentPanel.add(lblPno);

	}

	public void flush() {
		TXTid.setText("");
		TXTPno.setText("");
	}

		// 账号规范化

		public boolean checkid() {

		if (TXTid.getText().length() == 0) {// 获取编号输入框的内容

		lblid.setText("编号不能为空");

		TXTid.requestFocus();// 编号输入框获取焦点

		return false;

		}

		return true;

		}
		public boolean checkPno() {

			if (TXTPno.getText().length() == 0) {// 获取项目编号输入框的内容

			lblPno.setText("项目编号不能为空");

			TXTPno.requestFocus();// 项目编号输入框获取焦点

			return false;

			}

			return true;

			}
}
