package cn.edu.jsu.ll.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage window = new Homepage();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Homepage() {
		initualize();
	}

	private void initualize() {
		// TODO Auto-generated method stub
		frame =new JFrame("");
		frame.setBackground(Color.WHITE);
		frame.setTitle("\u8FD0\u52A8\u4F1A\u7BA1\u7406\u7CFB\u7EDF");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 659, 384);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8FD0\u52A8\u4F1A\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setBounds(161, 67, 226, 69);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 30));
		
		frame.getContentPane().add(lblNewLabel);
		
		JButton Enter_main = new JButton("\u767B\u5F55");
		Enter_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login=new Login();
				login.main(null);
				frame.dispose();
			}
		});
		Enter_main.setBounds(538, 10, 97, 23);
		frame.getContentPane().add(Enter_main);
		
		JButton Exit = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		Exit.setBounds(538, 314, 97, 23);
		frame.getContentPane().add(Exit);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register().main(null);
			}
		});
		btnNewButton.setBounds(538, 52, 97, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
