package cn.edu.jsu.ll.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.table.DefaultTableModel;

public class AthOperate_txt {
	final static File file = new File("D:\\java\\sign.txt");
	public static boolean addid(String id, String uid,String pno) {
		try (FileReader fr = new FileReader(file); FileWriter fw = new FileWriter(file, true);) {
			char[] tmp = new char[1024];
			int len = 0;
			while ((len = fr.read(tmp)) != -1) {
				if (new String(tmp, 0, len).contains(uid)&&new String(tmp, 0, len).contains(pno))
					return false;
			}
			fw.write(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean Find(String id) {
		try (FileReader fr = new FileReader(file); FileWriter fw = new FileWriter(file, true);) {
			char[] tmp = new char[1024];
			int len = 0;
			while ((len = fr.read(tmp)) != -1) {
				if (new String(tmp, 0, len).contains(id))
					
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void initTable(DefaultTableModel model) {
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
			String row = null;
			while ((row = br.readLine()) != null) {
				model.addRow(row.split("\t"));// ����ȡ���а��ָ�����ֳ��ַ��������������ģ�ͣ��ؼ�����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addData(DefaultTableModel model) {
		String temp = null;
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));) {
			for (int i = 0; i < model.getRowCount(); i++) {// ����������ݣ����뼯����
				String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t";// ��ȡ�����ÿһ�е�ÿһ����Ԫ��
				bw.write(row);// ���ı��ļ�����������
				bw.newLine();// д��س�����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void Delete(DefaultTableModel model) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			  for (int i = 0; i < model.getRowCount(); i++) {// ����������ݣ����뼯����
			String row = model.getValueAt(i, 0).toString() + "\t" + model.getValueAt(i, 1).toString() + "\t"+ model.getValueAt(i, 2).toString() + "\t";// ��ȡ�����ÿһ�е�ÿһ����Ԫ��
			    bw.write(row);// ���ı��ļ�����������
			    bw.newLine();// д��س�����
			  }
			} catch (Exception e1) {
			  e1.printStackTrace();
			}

	}
}