package cn.edu.jsu.ll.frm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 512, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JButton Managemessage = new JButton("\u8FD0\u52A8\u5458\u4FE1\u606F\u7BA1\u7406");
		Managemessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Athletemessage().main(null);
			}
		});
		Managemessage.setBounds(35, 39, 126, 23);
		frame.getContentPane().add(Managemessage);
		
		JButton managegrade = new JButton("\u6210\u7EE9\u7BA1\u7406");
		managegrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Gradeoperate().main(null);
			}
		});
		managegrade.setBounds(35, 72, 126, 23);
		frame.getContentPane().add(managegrade);
		
		JButton manage = new JButton("\u767B\u5F55\u4FE1\u606F");
		manage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		manage.setBounds(35, 105, 126, 23);
		frame.getContentPane().add(manage);
		
		JButton ManageProject = new JButton("\u9879\u76EE\u4FE1\u606F\u7BA1\u7406");
		ManageProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Projectmessage_Admin().main(null);
			}
		});
		ManageProject.setBounds(35, 138, 126, 23);
		frame.getContentPane().add(ManageProject);
	}

}
