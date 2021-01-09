package cn.edu.jsu.ll.frm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.ll.dao.AthOperate_txt;
import cn.edu.jsu.ll.dao.PageController;
import cn.edu.jsu.ll.dao.UserMatch;
import cn.edu.jsu.ll.dbc.DatabaseConnectionSql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ItemEvent;

public class Athletemessage extends JFrame {
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private JTextField txtKey;// ������ҹؼ����ı���
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;// ����������
	private ArrayList<RowSorter.SortKey> sortKeys;// �����������

	private Vector<String> titles;

	public static void main(String[] args) {
		Athletemessage frame = new Athletemessage();// ʵ��������
		frame.setLocationRelativeTo(null);// �������
		frame.setVisible(true);// ����ɼ�
	}

	/**
	 * ���幹�췽���������弰���.
	 */
	public Athletemessage() {
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
		Collections.addAll(titles, "���", "����", "�Ա�", "����");
		Vector<Vector> stuInfo = new PageController().getPaegData();// ��ȡ��һҳ������

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(stuInfo, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {// ��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		table.setAutoCreateRowSorter(true);
		;// ���ñ���Զ�����

		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ

		JLabel lblKey = new JLabel("\u8F93\u5165\u5173\u952E\u5B57\uFF1A");
		lblKey.setBounds(22, 21, 95, 15);
		contentPane.add(lblKey);

		txtKey = new JTextField();
		txtKey.setBounds(117, 18, 119, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		// ������Ұ�ť
		JButton btnFind = new JButton("����");
		String sql1="select *from Athlete ";
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = txtKey.getText().trim();// ��ȡ����ؼ����ı����ֵ
				if(key.length()!=0) {
					String sql="select * from Athlete where id="+key;
					model=new DefaultTableModel(new UserMatch().Find(sql),titles);//��������ģ��
					table.setModel(model);											
				}else {
					model=new DefaultTableModel(new UserMatch().getSelectAll(sql1),titles);//��������ģ��
					table.setModel(model);
				}

			}
		});
		btnFind.setBounds(246, 16, 95, 25);
		contentPane.add(btnFind);

		JButton btnPre = new JButton("��һҳ");
		btnPre.addActionListener(new ActionListener() {// ��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().prePage(), titles);// ��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);// ���ñ�������ģ��

			}
		});
		btnPre.setBounds(44, 302, 95, 25);
		contentPane.add(btnPre);

		JButton btnNext = new JButton("��һҳ");
		btnNext.addActionListener(new ActionListener() {// ��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().nextPage(), titles);// ��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);// ���ñ�������ģ��
			}
		});
		btnNext.setBounds(149, 302, 95, 25);
		contentPane.add(btnNext);

		JLabel lblMsg = new JLabel("ÿҳ��ʾ��");
		lblMsg.setBounds(254, 307, 87, 15);
		contentPane.add(lblMsg);

		JComboBox comboBox = new JComboBox(new Integer[] { 3, 5, 10, 15, 20 });
		comboBox.addItemListener(new ItemListener() {// ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize = Integer.valueOf(comboBox.getSelectedItem().toString());// ��ȡ��������ѡ��ֵ
				PageController pcl = new PageController();
				pcl.setCountPerpage(pageSize);// ����ÿҳ��ʾ��¼����
				model = new DefaultTableModel(pcl.getPaegData(), titles);// ��������ģ��
				table.setModel(model);// ���ñ������ģ��
			}
		});
		comboBox.setSelectedIndex(1);// ����������Ĭ��ֵ
		comboBox.setBounds(318, 303, 55, 23);
		contentPane.add(comboBox);

		JButton Delete = new JButton("\u5220\u9664");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=txtKey.getText().trim();
				Connection conn=new DatabaseConnectionSql().getConnection();
				Statement state=null;
				try {
					state=conn.createStatement();
				}catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
				String sql="delete from Athlete where id="+key;
				try {
					state.executeUpdate(sql);
				}catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				try {
					conn.close();
				}catch (SQLException e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			}
		});
		Delete.setBounds(359, 17, 67, 25);
		contentPane.add(Delete);
		
		JLabel lblNewLabel = new JLabel("(\u6309\u7167\u7F16\u53F7)");
		lblNewLabel.setBounds(32, 46, 67, 21);
		contentPane.add(lblNewLabel);
	}
}