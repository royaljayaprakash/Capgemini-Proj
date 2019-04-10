package com.caps.dev.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dev.model.beans.RoomDetails;
import com.caps.dev.model.beans.Users;
import com.caps.dev.model.dao.JDBCImpl;
import com.caps.dev.model.dao.UserDAO;
import com.caps.dev.services.HBMSService;
import com.mysql.cj.jdbc.Blob;

@WebServlet("/RoomDetails")
public class RoomDetailsServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hotelId = Integer.parseInt(req.getParameter("hotelId"));
		int roomId = Integer.parseInt(req.getParameter("roomId"));
		String roomType = req.getParameter("roomType");
		int perNightRate = Integer.parseInt(req.getParameter("perNightRate"));
		boolean availability = Boolean.parseBoolean(req.getParameter("availability"));
		Blob photo = (Blob) req.getPart("blob");

		RoomDetails rs = new RoomDetails();
		rs.setHotelId(hotelId);
		rs.setRoomId(roomId);
		rs.setRoomType(roomType);
		rs.setPerNightRate(perNightRate);
		rs.setAvailability(availability);
		rs.setPhoto(photo);

		HBMSService s = new HBMSService();
		RoomDetails rds = s.roomDetails(hotelId, roomId, roomType, perNightRate, availability, photo);
		
		if (rds != null) {

			req.getRequestDispatcher("/bookingDetails.jsp").forward(req, resp);
		} else {
			req.setAttribute("errMessage", rds);
			req.getRequestDispatcher("/Signup.jsp");
		}
	}

}
