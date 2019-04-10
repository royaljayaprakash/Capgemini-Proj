package com.caps.dev.model.dao;

import javax.servlet.http.Part;

import com.caps.dev.model.beans.RoomDetails;
import com.caps.dev.model.beans.Users;
import com.mysql.cj.jdbc.Blob;

public interface UserDAO {
	public Users login(int userId, String password);

	public Users userSignUp(Users user);

	public RoomDetails roomDetails(int hotelId, int roomId, String roomType, int perNightRate, boolean availability,
			Blob photo);

}
