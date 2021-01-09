package cn.edu.jsu.ll.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.ll.dao.AthOperate_txt;
import cn.edu.jsu.ll.dao.PageController1;
import cn.edu.jsu.ll.dao.UserMatch;
import cn.edu.jsu.ll.dbc.DatabaseConnectionSql;

public class Projectmessage extends JFrame {

	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private JTextField txtKey;// ������ҹؼ����ı���
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;// ����������
	private ArrayList<RowSorter.SortKey> sortKeys;// �����������

	private Vector<String> titles;
	private JButton delete;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projectmessage frame = new Projectmessage();
					frame.setLocationRelativeTo(null);// �������
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Projectmessage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 450, 403);// ���ô���λ�����С
		contentPane = new JPanel();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(44, 82, 346, 210);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "��Ŀ���", "��Ŀ����");
		String sql1="select *from Project ";
		Vector<Vector> stuInfo = new UserMatch().getSelectAll1(sql1);// ��ȡ��һҳ������

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(stuInfo, titles);
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		table.setAutoCreateRowSorter(true);
		;// ���ñ���Զ�����

		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ

		JLabel lblKey = new JLabel("����ؼ��֣�");
		lblKey.setBounds(44, 21, 79, 15);
		contentPane.add(lblKey);

		txtKey = new JTextField();//����ؼ��ֵ��ı���
		txtKey.setBounds(117, 18, 119, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		// ������Ұ�ť
		JButton btnFind = new JButton("����");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = txtKey.getText().trim();// ��ȡ����ؼ����ı����ֵ
				if(key.length()!=0) {
					String sql="select * from Project where pno='"+key+"'";//�����ݿ��в�ѯ����
					model=new DefaultTableModel(new UserMatch().Find2(sql),titles);//��������ģ��
					table.setModel(model);											
				}else {
					model=new DefaultTableModel(new UserMatch().getSelectAll1(sql1),titles);//��������ģ��
					table.setModel(model);
				}

			}
		});
		btnFind.setBounds(246, 16, 95, 25);
		contentPane.add(btnFind);
		
	}

}
