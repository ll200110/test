package cn.edu.jsu.ll.frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.ll.dao.AthOpterate_excel;
import cn.edu.jsu.ll.dao.UserMatch;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField username;
	private JPasswordField pw;
	private JLabel usernameMsg;
	private JLabel pwMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("\u767B\u5F55");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBounds(47, 68, 58, 19);
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(47, 121, 58, 19);
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));

		username = new JTextField();
		username.setBounds(109, 65, 164, 30);
		username.setColumns(10);

		pw = new JPasswordField();
		pw.setBounds(109, 113, 164, 27);

		JButton Enter = new JButton("\u767B\u5F55");
		Enter.setBounds(85, 175, 76, 23);
		Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Enter_ActionEvent(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton Cancel = new JButton("\u53D6\u6D88");
		Cancel.setBounds(203, 175, 70, 23);
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnreset_ActionEvent(e);
			}
		});

		JLabel usernameMsg = new JLabel("");
		usernameMsg.setBounds(283, 63, 128, 30);
		usernameMsg.setForeground(Color.RED);
		JLabel pwMsg = new JLabel("");
		pwMsg.setBounds(283, 113, 128, 25);
		pwMsg.setForeground(Color.RED);
		contentPanel.setLayout(null);
		contentPanel.add(lblNewLabel_1);
		contentPanel.add(pw);
		contentPanel.add(lblNewLabel);
		contentPanel.add(username);
		contentPanel.add(Enter);
		contentPanel.add(Cancel);
		contentPanel.add(usernameMsg);
		contentPanel.add(pwMsg);
	}

	public void flush() {
		username.setText("");
		pw.setText("");
		pwMsg.setText("");
		usernameMsg.setText("");
	}

	public void Enter_ActionEvent(ActionEvent e) throws IOException {
		String account = username.getText();
		String pwd =pw.getText();
		String sql = "SELECT *\r\n"
				+ "  FROM [User];";
		if (account.equals("")) {
			JOptionPane.showMessageDialog(null, "ÕËºÅ²»ÄÜÎª¿Õ", "´íÎó", JOptionPane.ERROR_MESSAGE);
		} else if (pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "ÃÜÂë²»ÄÜÎª¿Õ", "´íÎó", JOptionPane.ERROR_MESSAGE);
		} else if (UserMatch.getSelect(sql)) {
			JOptionPane.showMessageDialog(null, "µÇÂ¼³É¹¦", "", JOptionPane.ERROR_MESSAGE);
			String sql2="select name from Athlete where id='"+account+"'";
			System.out.println(sql2);
			String name1=new UserMatch().getSelectAll3(sql2);
			In(name1);
			this.dispose();
			if(account.equals("2019401316")) {
				new Main().main(null);
			}
			else {
				new Athleteoperate().main(null);
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "ÕËºÅ»òÃÜÂë´íÎó", "´íÎó", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void btnreset_ActionEvent(ActionEvent e) {
		username.setText("");
		pw.setText("");
	}
	public static void In(String str) throws IOException {
		File file =new File("D:"+File.separator+"java"+File.separator+"Login.txt");
		FileOutputStream fo =new FileOutputStream(file,true);
		SimpleDateFormat ds= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ans=str+"ÔÚ"+ds.format(new Date())+"³É¹¦µÇÂ½\r\n";
		fo.write(ans.getBytes());
		fo.close();
	}

}
