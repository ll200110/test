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
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	boolean flag = false;
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		if(rs.next()) {
	    			flag=true;
	    		}
	    			
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return flag;
	    }
		public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			Vector row=new Vector();//定义行数据
	    			row.add(rs.getString(1));//获取第一个字段学号
	    			row.add(rs.getString(2));//获取第二个字段姓名
	    			row.add(rs.getString(3));//获取第三个字段性别
	    			row.add(rs.getInt(4));
	    			rows.add(row);//将行数据添加到记录集合中
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//返回所有行数据
	    }
		public static Vector<Vector> getSelectAll1(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			Vector row=new Vector();//定义行数据
	    			row.add(rs.getString(1));//获取第一个字段项目编号
	    			row.add(rs.getString(2));//获取第二个字段项目名称
	    			rows.add(row);//将行数据添加到记录集合中
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//返回所有行数据
	    }
		public static Vector<Vector> getSelectAll2(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			Vector row=new Vector();//定义行数据
	    			row.add(rs.getString(1));//获取第一个字段学号
	    			row.add(rs.getString(2));//获取第二个字段项目编号
	    			row.add(rs.getInt(3));//获取第三个字段成績
	    			rows.add(row);//将行数据添加到记录集合中
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//返回所有行数据
	    }
		public static String getSelectAll3(String sql){
	    	String name=null;//定义要返回的所有记录集合
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			name=rs.getString(1);
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return name;//返回登录人员的姓名
	    }
		public static Vector<Vector> Find(String sql){
			Vector<Vector> rows=new Vector<Vector>();
			DatabaseConnectionSql db=new DatabaseConnectionSql();
			try(Connection conn=db.getConnection();Statement stm=conn.createStatement();) {
				ResultSet rs=stm.executeQuery(sql); 
				while(rs.next()) { 
					Vector row=new Vector();//定义行数据 
	    			row.add(rs.getString(1));//获取第一个字段学号
	    			row.add(rs.getString(2));//获取第二个字段姓名 
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
					Vector row=new Vector();//定义行数据 
	    			row.add(rs.getString(1));//获取第一个字段项目编号
	    			row.add(rs.getString(2));//获取第二个字段姓名
	    			rows.add(row);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block 
				e1.printStackTrace();
			}  
			return rows;
		}
		
}
