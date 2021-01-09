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
 * ����JTable��ʾ�ı��ļ����ݣ�����ѧ������
 * 
 * @author ����
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

		JLabel lblNewLabel = new JLabel("��ѯ�ؼ���");

		lblNewLabel.setBounds(17, 43, 66, 15);

		contentPane.add(lblNewLabel);

		textFind = new JTextField();

		textFind.setBounds(93, 40, 113, 21);

		contentPane.add(textFind);

		textFind.setColumns(10);

		JButton inquire = new JButton("��ѯ");

		inquire.setBounds(216, 39, 75, 23);

		contentPane.add(inquire);

		JButton delete = new JButton("ɾ��");

		delete.setBounds(301, 39, 95, 23);

		contentPane.add(delete);

		JButton updata = new JButton("\u5237\u65B0");

		updata.setBounds(420, 39, 85, 23);

		contentPane.add(updata);

// =======�������===========

		String[] title = { "ѧ��", "��Ŀ���" };// ���������ʾ������

		DefaultTableModel model = new DefaultTableModel(title, 0);// ����������ģ�͵ı����������(Ϊ0��)

		AthOperate_txt.initTable(model);// ���÷���װ������

		table = new JTable(model) {

			@Override

			public boolean isCellEditable(int row, int column) {

				if (column == 0) {// ���õ�1�в��ɱ༭

					return false;

				}

				return true;

			}

		};// ʵ�������װ�ر��ģ��ʵ��

		scrollPane.setViewportView(table);

		table.setAutoCreateRowSorter(true);

		inquire.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(AthOperate_txt.Find(textFind.getText())) {
					
				}else {
					JOptionPane.showMessageDialog(null, "���޴���Ϣ");
				}
				
			}

		});

		delete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {// �Ƿ�ѡ����Ҫɾ������
					  if (JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��������", "",    JOptionPane.YES_NO_OPTION) == 0) {// ȷ���Ի���
					    model.removeRow(table.convertRowIndexToModel(table.getSelectedRow()));
					    AthOperate_txt.Delete(model);
					    //�ӱ��������ɾ����,model1ΪDefaultTableModel���ͣ��������ֱ��ʹ�ñ���getSelectedRow������ȡ��ѡ�е���
					  } else {
					    JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ������");
					  }

					}


			}

		});

		updata.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				AthOperate_txt.addData(model);
				JOptionPane.showMessageDialog(null, "ˢ�³ɹ�");

			}

		});

	}

}