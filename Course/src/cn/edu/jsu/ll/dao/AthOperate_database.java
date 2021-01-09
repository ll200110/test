package cn.edu.jsu.ll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.edu.jsu.ll.dbc.DatabaseConnectionSql;

public class AthOperate_database {
	public static void main(String[] args) {
		addAthlete();
	}

	public static void addgrade(String x, String y, int z) {
		DatabaseConnectionSql dbcs = new DatabaseConnectionSql();// �������ݿ�

		String sql = "insert into Grade(id,pno,score) values(?,?,?)";// ʹ��ռλ������������
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��

				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����PreparedStatement

			pstmt.setString(1, x);// �����1��ռλ��������

			pstmt.setString(2, y);// �����2��ռλ��������

			pstmt.setInt(3, z);

			pstmt.addBatch();// ����������ȴ�ִ
			pstmt.executeBatch();// ����ִ�в������

			JOptionPane.showMessageDialog(null, "��ӳɹ�");

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}
	public static void Updatagrade(String x, String y, int z) {
		
		DatabaseConnectionSql dbcs = new DatabaseConnectionSql();// �������ݿ�
		
		String sql = "updata grade set score="+ z +" where id='"+ x +"' and pno='"+ y +"'";// ʹ��ռλ������������
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��
				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����PreparedStatement
			
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�");

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public static void addAthlete() {// �����˶�Ա

		DatabaseConnectionSql dbcs = new DatabaseConnectionSql();// �������ݿ�

		String sql = "insert into Athlete(id,name,sex,age) values(?,?,?,?)";// ʹ��ռλ������������
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��

				PreparedStatement pstmt = conn.prepareStatement(sql);) {// ʵ����PreparedStatement

			ArrayList<String> alist = new ArrayList<String>();// ���弯��

			for (int i = 1; i <=10000;) {

				String id = getStuno().toString();// �����ȡѧ��

				int x;

				String sex;

				if (!alist.contains(id)) {// �ж�ѧ���Ƿ�Ψһ

					alist.add(id);// ��ѧ�ż��뼯��

					x = getsex();

					String name = getName(x);// �����ȡ����

					if (x == 0) {

						sex = "��";

					}

					else {

						sex = "Ů";

					}

					int age = getNum(18, 22);// �����ȡ�ɼ�

					pstmt.setString(1, id);// �����1��ռλ��������

					pstmt.setString(2, name);// �����2��ռλ��������

					pstmt.setString(3, sex);// �����3��ռλ��������
					pstmt.setInt(4, age);

					pstmt.addBatch();// ����������ȴ�ִ��

					i++;// ѧ��Ψһ��ѭ����������ִ��

				}

			}

			pstmt.executeBatch();// ����ִ�в������

			JOptionPane.showMessageDialog(null, "success");

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	private static String firstName = "��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	// ����Ů������
	private static String girl = "���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	// ������������
	private static String boy = "ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";

	public static int getNum(int start, int end) {// ������ط���ָ����Χ�������
		// Math.random()�������0.0��1.0֮�����
		return (int) (Math.random() * (end - start + 1) + start);
	}

	public static int getsex() {

		return getNum(0, 1);

	}

	// �������ѧ��
	public static StringBuilder getStuno() {// ��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
		StringBuilder xh = new StringBuilder("20194");// ѧ��ǰ5λ��ͬ
		StringBuilder xh1 = new StringBuilder(String.valueOf(getNum(1, 99999)));// ���ȡ��5λ
		if (xh1.length() == 1) {
			xh1 = xh1.insert(0, "0000");// �����1λ����ǰ������2��0
			xh = xh.append(xh1);// ǰ6λ���3λƴ�ӳ�ѧ��
		} else if (xh1.length() == 2) {
			xh1 = xh1.insert(0, "000");// �����2λ����ǰ������1��0
			xh = xh.append(xh1);
		} else if(xh1.length()==3){//�����3λ��
			xh1 = xh1.insert(0, "00");
			xh = xh.append(xh1);
		}else if (xh1.length()==4){
			xh1 = xh1.insert(0, "0");
			xh = xh.append(xh1);
		}else {
			xh = xh.append(xh1);
		}
		return xh;
	}

	// ���������������
	public static String getName(int x) {
		int index = getNum(0, firstName.length() - 1);// ���ȡ�����ַ����е�����λ��

		String first = firstName.substring(index, index + 1);// ��ȡ��λ�õ�����

		int sex = x;// ���ȡ�Ա�����1Ϊ������0ΪŮ��

		String str = boy;// ��������Ϊ�����ַ���

		int length = boy.length();// ��ȡ�����ַ����ĳ���

		if (sex == 0) {// ��������ȡΪ0�������ָ�ΪŮ��

			str = girl;

			length = girl.length();

		}

		index = getNum(0, length - 1);// �����ȡ���ֵ�λ��

		String second = str.substring(index, index + 1);// ��ȡ��λ���е�����

		int hasThird = getNum(0, 1);// �����ȡ�����Ƿ��е�������

		String third = "";// Ĭ��û�е�������

		if (hasThird == 1) {// ��������ȡΪ1�����е�������

			index = getNum(0, length - 1);

			third = str.substring(index, index + 1);

		}

		return first + second + third;// ��������

	}

	public static void add(String s, String m) {
		DatabaseConnectionSql dbcs = new DatabaseConnectionSql();// �������ݿ�

		String sql1 = "insert into [User](id,password) values(?,?)";// ʹ��ռλ������������
		try (Connection conn = dbcs.getConnection(); // ��ȡ���ݿ��

				PreparedStatement pstmt = conn.prepareStatement(sql1);) {// ʵ����PreparedStatement

			ArrayList<String> alist = new ArrayList<String>();// ���弯��

			pstmt.setString(1, s);// �����1��ռλ��������

			pstmt.setString(2, m);// �����2��ռλ��������

			pstmt.addBatch();// ����������ȴ�ִ��
			pstmt.executeBatch();// ����ִ�в������

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
}
