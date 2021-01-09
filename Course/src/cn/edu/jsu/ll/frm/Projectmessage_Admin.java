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
import cn.edu.jsu.ll.dao.PageController1;
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

public class Projectmessage_Admin extends JFrame {
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private JTextField txtKey;// 定义查找关键字文本框
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;// 定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;// 设置排序规则

	private Vector<String> titles;

	public static void main(String[] args) {
		Projectmessage_Admin frame = new Projectmessage_Admin();// 实例化窗体
		frame.setLocationRelativeTo(null);// 窗体居中
		frame.setVisible(true);// 窗体可见
	}

	/**
	 * 定义构造方法创建窗体及组件.
	 */
	public Projectmessage_Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭按钮
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
		Collections.addAll(titles, "项目编号","项目名称");
		String sql1="select *from Project ";
		Vector<Vector> stuInfo = new UserMatch().getSelectAll1(sql1);// 获取第一页的数据

//		使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(stuInfo, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {// 获取列的类型
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		table.setAutoCreateRowSorter(true);
		;// 设置表格自动排序

		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示

		JLabel lblKey = new JLabel("\u8F93\u5165\u5173\u952E\u5B57\uFF1A");
		lblKey.setBounds(22, 21, 95, 15);
		contentPane.add(lblKey);

		txtKey = new JTextField();
		txtKey.setBounds(117, 18, 119, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		// 定义查找按钮
		JButton btnFind = new JButton("查找");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = txtKey.getText().trim();// 获取输入关键字文本框的数据
				if(key.length()!=0) {
					String sql="select * from Project where pno='"+key+"'";
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
				String sql="delete from Project where pno="+key;
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
				JOptionPane.showMessageDialog(null, "删除成功");
			}
		});
		Delete.setBounds(359, 17, 67, 25);
		contentPane.add(Delete);
		
		JLabel lblNewLabel = new JLabel("(\u6309\u7167\u7F16\u53F7)");
		lblNewLabel.setBounds(32, 46, 67, 21);
		contentPane.add(lblNewLabel);
		
		JButton refresh = new JButton("\u5237\u65B0");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new UserMatch().getSelectAll1(sql1),titles);//设置数据模型
				table.setModel(model);
			}
		});
		refresh.setBounds(329, 333, 97, 23);
		contentPane.add(refresh);
	}
}