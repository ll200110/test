package cn.edu.jsu.ll.frm;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Athleteoperate {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Athleteoperate window = new Athleteoperate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Athleteoperate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7528\u6237\u64CD\u4F5C\u9875\u9762");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton Projectmessage = new JButton("\u67E5\u770B\u9879\u76EE\u4FE1\u606F");
		Projectmessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Projectmessage().main(null);
				
			}
		});
		Projectmessage.setBounds(10, 33, 105, 23);
		frame.getContentPane().add(Projectmessage);
		
		JButton applymessage = new JButton("\u67E5\u770B\u62A5\u540D\u4FE1\u606F");
		applymessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManageRegistrations().main(null);
			}
		});
		applymessage.setBounds(10, 81, 105, 23);
		frame.getContentPane().add(applymessage);
		
		JButton apply = new JButton("\u62A5\u540D");
		apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addData().main(null);
			}
		});
		apply.setBounds(10, 127, 105, 23);
		frame.getContentPane().add(apply);
		
		JButton btnNewButton_3 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_3.setBounds(329, 230, 97, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton viewgrade = new JButton("\u67E5\u770B\u6BD4\u8D5B\u6210\u7EE9");
		viewgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gradeoperate().main(null);
			}
		});
		viewgrade.setBounds(10, 175, 105, 23);
		frame.getContentPane().add(viewgrade);
	}
}
