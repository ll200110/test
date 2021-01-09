package cn.edu.jsu.ll.frm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import java.util.ArrayList;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableRowSorter;

import javax.swing.text.TableView.TableRow;

import cn.edu.jsu.ll.dao.AthOperate_txt;

import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JTextField;

import javax.swing.RowFilter;

import javax.swing.RowFilter.ComparisonType;

import javax.swing.RowSorter;

import javax.swing.SortOrder;

import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.io.BufferedWriter;

import java.awt.event.ActionEvent;

import java.awt.Color;

/**
 * 
 * 利用JTable显示文本文件内容，并按学号排序
 * 
 * @author 刘磊
 *
 * 
 * 
 */

public class ManageRegistrations extends JFrame {

	private JPanel contentPane;

	private JTable table;

	private JTextField textFind;

	/**
	 * 
	 * Launch the application.
	 * 
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					ManageRegistrations frame = new ManageRegistrations();

					frame.setLocationRelativeTo(null);

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	/**
	 * 
	 * Create the frame.
	 * 
	 */

	public ManageRegistrations() {

		setTitle("\u62A5\u540D\u4FE1\u606F\u7BA1\u7406");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 586, 373);

		contentPane = new JPanel();

		contentPane.setBackground(Color.WHITE);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 121, 541, 176);

		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("查询关键字");

		lblNewLabel.setBounds(17, 43, 66, 15);

		contentPane.add(lblNewLabel);

		textFind = new JTextField();

		textFind.setBounds(93, 40, 113, 21);

		contentPane.add(textFind);

		textFind.setColumns(10);

		JButton inquire = new JButton("查询");

		inquire.setBounds(216, 39, 75, 23);

		contentPane.add(inquire);

		JButton delete = new JButton("删除");

		delete.setBounds(301, 39, 95, 23);

		contentPane.add(delete);

		JButton updata = new JButton("\u5237\u65B0");

		updata.setBounds(420, 39, 85, 23);

		contentPane.add(updata);

// =======创建表格===========

		String[] title = { "学号", "项目编号" };// 定义数组表示表格标题

		DefaultTableModel model = new DefaultTableModel(title, 0);// 定义表格数据模型的表格标题和行数(为0行)

		AthOperate_txt.initTable(model);// 调用方法装载数据

		table = new JTable(model) {

			@Override

			public boolean isCellEditable(int row, int column) {

				if (column == 0) {// 设置第1列不可编辑

					return false;

				}

				return true;

			}

		};// 实例化表格装载表格模型实例

		scrollPane.setViewportView(table);

		table.setAutoCreateRowSorter(true);

		inquire.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(AthOperate_txt.Find(textFind.getText())) {
					
				}else {
					JOptionPane.showMessageDialog(null, "查无此信息");
				}
				
			}

		});

		delete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {// 是否选择了要删除的行
					  if (JOptionPane.showConfirmDialog(null, "确定要删除数据吗？", "",    JOptionPane.YES_NO_OPTION) == 0) {// 确定对话框
					    model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
					    AthOperate_txt.Delete(model);
					    //从表格数据中删除行,model1为DefaultTableModel类型，排序后不能直接使用表格的getSelectedRow方法获取被选中的行
					  } else {
					    JOptionPane.showMessageDialog(null, "请选择要删除的行");
					  }

					}


			}

		});

		updata.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				AthOperate_txt.addData(model);
				JOptionPane.showMessageDialog(null, "刷新成功");

			}

		});

	}

}