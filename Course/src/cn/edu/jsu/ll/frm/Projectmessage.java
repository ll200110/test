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

	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private JTextField txtKey;// 定义查找关键字文本框
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;// 定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;// 设置排序规则

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
					frame.setLocationRelativeTo(null);// 窗体居中
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 450, 403);// 设置窗体位置与大小
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(44, 82, 346, 210);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "项目编号", "项目名称");
		String sql1="select *from Project ";
		Vector<Vector> stuInfo = new UserMatch().getSelectAll1(sql1);// 获取第一页的数据

//		使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(stuInfo, titles);
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		table.setAutoCreateRowSorter(true);
		;// 设置表格自动排序

		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示

		JLabel lblKey = new JLabel("输入关键字：");
		lblKey.setBounds(44, 21, 79, 15);
		contentPane.add(lblKey);

		txtKey = new JTextField();//输入关键字的文本框
		txtKey.setBounds(117, 18, 119, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		// 定义查找按钮
		JButton btnFind = new JButton("查找");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = txtKey.getText().trim();// 获取输入关键字文本框的值
				if(key.length()!=0) {
					String sql="select * from Project where pno='"+key+"'";//从数据库中查询数据
					model=new DefaultTableModel(new UserMatch().Find2(sql),titles);//设置数据模型
					table.setModel(model);											
				}else {
					model=new DefaultTableModel(new UserMatch().getSelectAll1(sql1),titles);//设置数据模型
					table.setModel(model);
				}

			}
		});
		btnFind.setBounds(246, 16, 95, 25);
		contentPane.add(btnFind);
		
	}

}
