package com.caps.dev.services;

import com.caps.dev.model.beans.RoomDetails;
import com.caps.dev.model.beans.Users;
import com.caps.dev.model.dao.JDBCImpl;
import com.caps.dev.model.dao.UserDAO;
import com.mysql.cj.jdbc.Blob;

public class HBMSService {

	public Users loginService(int userId, String password) {
		UserDAO db = new JDBCImpl();
		Users USER = db.login(userId, password);
		return USER;

	}

	public Users signUp(Users user) {
		UserDAO db = new JDBCImpl();
		Users us = db.userSignUp(user);
		return user;

	}

	public RoomDetails roomDetails(int hotelId, int roomId, String roomType, int perNightRate, boolean availability,
			Blob photo) {
		UserDAO db = new JDBCImpl();
		RoomDetails rds = db.roomDetails(hotelId, roomId, roomType, perNightRate, availability, photo);
		return rds;

	}
}
