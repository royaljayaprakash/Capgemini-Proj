package com.employee.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			//con = DriverManager.getConnection(DbUtil.getDburl(),DbUtil.getDbusername(),DbUtil.getDbuserpassword());
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
	public Employee create(Employee e)
	{
		
		
		return null;
	}

	@Override
	public Employee update(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee delete(String Emp_ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean listAll(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
