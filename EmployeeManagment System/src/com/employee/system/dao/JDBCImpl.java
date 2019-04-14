package com.employee.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.caps.dev.util.DbUtil;
import com.employee.systems.dev.dto.Employee;
import com.employee.systems.dev.dto.Users;

public class JDBCImpl  implements UserDAO
{

	@Override
	public Users login(String userId, String password) {


		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Users us= null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//Class.forName(DbUtil.DRIVERCLASS);
			//con = DriverManager.getConnection(DbUtil.DBURL,DbUtil.USER,DbUtil.PASSWORD);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgeminiproj?user=root&password=root");
			String sql = "select * from user_master where UserId =? " + " and UserPassword=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				us = new Users();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return us;

	}

	@Override
	public boolean create(Employee e)
	{

		boolean result=false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try{
			//Class.forName(DbUtil.DRIVERCLASS);
			//con = DriverManager.getConnection(DbUtil.DBURL,DbUtil.USER,DbUtil.PASSWORD);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/capgeminiproj";
			connection = DriverManager.getConnection(dburl,"root","root");

			String query="insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?.?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,e.getEmp_ID());
			preparedStatement.setString(2,e.getEmp_First_Name());
			preparedStatement.setString(3,e.getEmp_Last_Name());
			preparedStatement.setString(4,e.getEmp_Date_of_Birth());
			preparedStatement.setString(5,e.getEmp_Date_of_Joining() );
			preparedStatement.setString(6,e.getEmp_Dept_ID());
			preparedStatement.setString(7,e.getEmp_Grade());
			preparedStatement.setString(8,e.getEmp_Designation());
			preparedStatement.setString(9,e.getEmp_Basic());
			preparedStatement.setString(10,e.getEmp_Gender() );
			preparedStatement.setString(11,e.getEmp_Marital_Status());
			preparedStatement.setString(12,e.getEmp_Home_Address());
			preparedStatement.setString(13,e.getEmp_Contact_Num());


			int count = preparedStatement.executeUpdate();
			if(count>0)
			{
				System.out.println("Created succesfully");
				result=true;
			}
			else
			{
				System.out.println("Something went wrong");

			}
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
		finally{
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(preparedStatement!=null)
			{
				try {
					preparedStatement.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		return result;

	}
	@Override
	public boolean update(Employee e) 
	{
		boolean result=false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try{
			//Class.forName(DbUtil.DRIVERCLASS);
			//con = DriverManager.getConnection(DbUtil.DBURL,DbUtil.USER,DbUtil.PASSWORD);
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3307/capgeminiproj";
			connection = DriverManager.getConnection(dburl,"root","root");
			
			String query = "Update Employee set  Emp_First_Name=? ,Emp_Last_Name =?,Emp_Date_of_Birth=? ,Emp_Date_of_Joining=? ,Emp_Designation=?,Emp_Basic=?, Emp_Gender=?,Emp_Marital_Status=? ,Emp_Home_Address =?,Emp_Contact_Num=?   where Emp_id=?";
			
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,e.getEmp_First_Name());
			preparedStatement.setString(2,e.getEmp_Last_Name());
			preparedStatement.setString(3,e.getEmp_Date_of_Birth());
			preparedStatement.setString(4,e.getEmp_Date_of_Joining());
			preparedStatement.setString(5,e.getEmp_Designation());
			preparedStatement.setString(6,e.getEmp_Basic() );
			preparedStatement.setString(7,e.getEmp_Marital_Status());
			preparedStatement.setString(8, e.getEmp_Home_Address());
			preparedStatement.setString(9,e.getEmp_Contact_Num());
			
			int count = preparedStatement.executeUpdate();
			if(count>0)
			{
				System.out.println("Updated succesfully");
				result=true;
			}
			else
			{
				System.out.println("Something went wrong");
				
			}
		}catch(Exception p)
		{
			p.printStackTrace();
		}
		finally{
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(preparedStatement!=null)
			{
				try {
					preparedStatement.close();
				} catch (SQLException k) {
					k.printStackTrace();
				}
			}
		}
		return result;
	
	}

	@Override
	public boolean delete(String Emp_ID) {

		boolean result=false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try{
			//Class.forName(DbUtil.DRIVERCLASS);
			//con = DriverManager.getConnection(DbUtil.DBURL,DbUtil.USER,DbUtil.PASSWORD);
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/capgeminiproj";
			connection = DriverManager.getConnection(dburl,"root","root");

			String query = "Delete from Employee where Emp_Id=?";

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1,Emp_ID);
			int count = preparedStatement.executeUpdate();
			if(count>0)
			{
				System.out.println("Deleted succesfully");
				return true;
			}
			else
			{
				System.out.println("Something went wrong");

			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null)
			{
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}





	@Override
	public void listAll(Employee e) 
	
	{
		//Class.forName(DbUtil.DRIVERCLASS);
		//con = DriverManager.getConnection(DbUtil.DBURL,DbUtil.USER,DbUtil.PASSWORD);

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3307/capgeminiproj";
			connection = DriverManager.getConnection(dburl,"root","root");
			
			String query = "Select * from Employee ";
			
			preparedStatement = connection.prepareStatement(query);
			
			
			
			resultSet = preparedStatement.executeQuery();
			int count = preparedStatement.executeUpdate();
			while(resultSet.next())
			{
				String id = resultSet.getString(1);
				String  fname= resultSet.getString(2);
				String lname = resultSet.getString(3);
				String dob = resultSet.getString(4);
				String joining= resultSet.getString(5);
				double deptid = resultSet.getDouble(6);
				String grade = resultSet.getString(7);
				String designation = resultSet.getString(8);
				String basic = resultSet.getString(9);
				String gender = resultSet.getString(10);
				String maritalstatus = resultSet.getString(11);
				String homeaddress = resultSet.getString(12);
				String phonenum = resultSet.getString(13);
				
				List<Employee> empdetails=new ArrayList<Employee>();
				
				for (Employee empdetails1 : empdetails) {
					System.out.println(empdetails1);
				}
				
			}
			
		}catch(Exception eu)
		{
			eu.printStackTrace();
		}
		finally{
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException o) {
					o.printStackTrace();
				}
			}
			if(preparedStatement!=null)
			{
				try {
					preparedStatement.close();
				} catch (SQLException i) {
					i.printStackTrace();
				}
			}
			if(resultSet!=null)
			{
				try {
					resultSet.close();
				} catch (SQLException p) {
					p.printStackTrace();
				}
				
			}
		}
	
	}



}
