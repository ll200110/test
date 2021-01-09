package cn.edu.jsu.ll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.jsu.ll.dbc.DatabaseConnectionSql;

public class UserMatch {
		public static void main(String []args) {
			
		}
		public static boolean getSelect(String sql){
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	boolean flag = false;
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		if(rs.next()) {
	    			flag=true;
	    		}
	    			
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return flag;
	    }
		public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
	    			Vector row=new Vector();//����������
	    			row.add(rs.getString(1));//��ȡ��һ���ֶ�ѧ��
	    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�����
	    			row.add(rs.getString(3));//��ȡ�������ֶ��Ա�
	    			row.add(rs.getInt(4));
	    			rows.add(row);//����������ӵ���¼������
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//��������������
	    }
		public static Vector<Vector> getSelectAll1(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
	    			Vector row=new Vector();//����������
	    			row.add(rs.getString(1));//��ȡ��һ���ֶ���Ŀ���
	    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ���Ŀ����
	    			rows.add(row);//����������ӵ���¼������
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//��������������
	    }
		public static Vector<Vector> getSelectAll2(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
	    			Vector row=new Vector();//����������
	    			row.add(rs.getString(1));//��ȡ��һ���ֶ�ѧ��
	    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ���Ŀ���
	    			row.add(rs.getInt(3));//��ȡ�������ֶγɿ�
	    			rows.add(row);//����������ӵ���¼������
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//��������������
	    }
		public static String getSelectAll3(String sql){
	    	String name=null;//����Ҫ���ص����м�¼����
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
	    			name=rs.getString(1);
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return name;//���ص�¼��Ա������
	    }
		public static Vector<Vector> Find(String sql){
			Vector<Vector> rows=new Vector<Vector>();
			DatabaseConnectionSql db=new DatabaseConnectionSql();
			try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
				ResultSet rs=stm.executeQuery(sql); 
				while(rs.next()) { 
					Vector row=new Vector();//���������� 
	    			row.add(rs.getString(1));//��ȡ��һ���ֶ�ѧ��
	    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ����� 
	    			row.add(rs.getString(3));
	    			row.add(rs.getInt(4)); 
	    			rows.add(row);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block 
				e1.printStackTrace();
			}  
			return rows;
		}
		public static Vector<Vector> Find2(String sql){
			Vector<Vector> rows=new Vector<Vector>();
			DatabaseConnectionSql db=new DatabaseConnectionSql();
			try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
				ResultSet rs=stm.executeQuery(sql); 
				while(rs.next()) { 
					Vector row=new Vector();//���������� 
	    			row.add(rs.getString(1));//��ȡ��һ���ֶ���Ŀ���
	    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�����
	    			rows.add(row);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block 
				e1.printStackTrace();
			}  
			return rows;
		}
		
}
