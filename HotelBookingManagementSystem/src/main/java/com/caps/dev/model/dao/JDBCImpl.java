 package com.caps.dev.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.http.Part;

import com.caps.dev.model.beans.RoomDetails;
import com.caps.dev.model.beans.Users;
import com.caps.dev.util.DbUtil;
import com.mysql.cj.jdbc.Blob;

public class JDBCImpl implements UserDAO {

	public Users login(int userId, String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Users s = null;
		try {

			con = DriverManager.getConnection(DbUtil.getDburl(),DbUtil.getDbusername(),DbUtil.getDbuserpassword());
			String sql = "select * from Users where userId =? " + " and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				s = new Users();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}

	@Override
	public Users userSignUp(Users us) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Users user = null;
		try {
			con = DriverManager.getConnection(DbUtil.getDburl(),DbUtil.getDbusername(),DbUtil.getDbuserpassword());
			String sql = "insert into Users values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRole());

			pstmt.setLong(5, user.getMobileno());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getEmail());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				user = new Users();

				System.out.println("registration successful");
			} else
				System.out.println("not successful");

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return user;
	}

	@Override
	public RoomDetails roomDetails(int hotelId, int roomId, String roomType, int perNightRate, boolean availability,
			Blob photo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RoomDetails rds = null;
		try {
			con = DriverManager.getConnection(DbUtil.getDburl(),DbUtil.getDbusername(),DbUtil.getDbuserpassword());
			String sql = "insert into roomDetails values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			if (rs.next()) {
				rds = new RoomDetails();
				pstmt.setInt(1, rds.getHotelId());
				pstmt.setInt(2, rds.getRoomId());
				pstmt.setInt(3, rds.getRoomNo());
				pstmt.setString(4, rds.getRoomType());
				pstmt.setInt(5, rds.getPerNightRate());
				// pstmt.setBoolean(6, ((rds) ).getBoolean();
				pstmt.setBinaryStream(7, ((Part) photo).getInputStream());
			}

			else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rds;
	}

}
