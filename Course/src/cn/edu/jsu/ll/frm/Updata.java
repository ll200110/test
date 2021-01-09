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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Updata extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField id;
	private JTextField s;
	private JTextField pno;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Updata dialog = new Updata();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Updata() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
			lblNewLabel.setBounds(57, 47, 58, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u9879\u76EE\u7F16\u53F7");
			lblNewLabel_1.setBounds(57, 87, 58, 15);
			contentPanel.add(lblNewLabel_1);
		}
		
		id = new JTextField();
		id.setBounds(150, 44, 101, 21);
		contentPanel.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6210\u7EE9");
		lblNewLabel_2.setBounds(57, 136, 58, 15);
		contentPanel.add(lblNewLabel_2);
		
		s = new JTextField();
		s.setBounds(150, 133, 101, 21);
		contentPanel.add(s);
		s.setColumns(10);
		
		pno = new JTextField();
		pno.setColumns(10);
		pno.setBounds(150, 84, 101, 21);
		contentPanel.add(pno);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539/\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from Grade where id='"+id.getText()+"' and pno='"+pno.getText()+"'";
				if(!UserMatch.getSelect(sql)) {
					new AthOperate_database().addgrade(id.getText(), pno.getText(), Integer.parseInt(s.getText()));	
					
				}else {
					new AthOperate_database().Updatagrade(id.getText(), pno.getText(), Integer.parseInt(s.getText()));
				}
								
			}
		});
		btnNewButton.setBounds(154, 184, 97, 23);
		contentPanel.add(btnNewButton);
	}
}
