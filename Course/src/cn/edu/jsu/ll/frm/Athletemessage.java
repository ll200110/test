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
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private JTextField txtKey;// 定义查找关键字文本框
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;// 定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;// 设置排序规则

	private Vector<String> titles;

	public static void main(String[] args) {
		Athletemessage frame = new Athletemessage();// 实例化窗体
		frame.setLocationRelativeTo(null);// 窗体居中
		frame.setVisible(true);// 窗体可见
	}

	/**
	 * 定义构造方法创建窗体及组件.
	 */
	public Athletemessage() {
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
		Collections.addAll(titles, "编号", "姓名", "性别", "年龄");
		Vector<Vector> stuInfo = new PageController().getPaegData();// 获取第一页的数据

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
		String sql1="select *from Athlete ";
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = txtKey.getText().trim();// 获取输入关键字文本框的值
				if(key.length()!=0) {
					String sql="select * from Athlete where id="+key;
					model=new DefaultTableModel(new UserMatch().Find(sql),titles);//设置数据模型
					table.setModel(model);											
				}else {
					model=new DefaultTableModel(new UserMatch().getSelectAll(sql1),titles);//设置数据模型
					table.setModel(model);
				}

			}
		});
		btnFind.setBounds(246, 16, 95, 25);
		contentPane.add(btnFind);

		JButton btnPre = new JButton("上一页");
		btnPre.addActionListener(new ActionListener() {// 上一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().prePage(), titles);// 设置数据模型中的数据为上一页内容
				table.setModel(model);// 设置表格的数据模型

			}
		});
		btnPre.setBounds(44, 302, 95, 25);
		contentPane.add(btnPre);

		JButton btnNext = new JButton("下一页");
		btnNext.addActionListener(new ActionListener() {// 下一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model = new DefaultTableModel(new PageController().nextPage(), titles);// 设置数据模型中的数据为下一页内容
				table.setModel(model);// 设置表格的数据模型
			}
		});
		btnNext.setBounds(149, 302, 95, 25);
		contentPane.add(btnNext);

		JLabel lblMsg = new JLabel("每页显示：");
		lblMsg.setBounds(254, 307, 87, 15);
		contentPane.add(lblMsg);

		JComboBox comboBox = new JComboBox(new Integer[] { 3, 5, 10, 15, 20 });
		comboBox.addItemListener(new ItemListener() {// 页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize = Integer.valueOf(comboBox.getSelectedItem().toString());// 获取下拉框所选的值
				PageController pcl = new PageController();
				pcl.setCountPerpage(pageSize);// 设置每页显示记录条数
				model = new DefaultTableModel(pcl.getPaegData(), titles);// 设置数据模型
				table.setModel(model);// 设置表格数据模型
			}
		});
		comboBox.setSelectedIndex(1);// 设置下拉框默认值
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
				JOptionPane.showMessageDialog(null, "删除成功");
			}
		});
		Delete.setBounds(359, 17, 67, 25);
		contentPane.add(Delete);
		
		JLabel lblNewLabel = new JLabel("(\u6309\u7167\u7F16\u53F7)");
		lblNewLabel.setBounds(32, 46, 67, 21);
		contentPane.add(lblNewLabel);
	}
}