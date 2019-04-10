package com.caps.dev.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dev.model.beans.Users;

import com.caps.dev.services.HBMSService;

@WebServlet("/signupServlet")
public class SignUpServ extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String pass = req.getParameter("password");
		String role = req.getParameter("role");
		String uname = req.getParameter("username");
		long mobile = Long.parseLong(req.getParameter("mobileno"));
		long phone = Long.parseLong(req.getParameter("phone"));
		String add = req.getParameter("address");
		String email = req.getParameter("email");

		Users u = new Users();

		u.setAddress(add);
		u.setEmail(email);
		u.setMobileno(mobile);
		u.setPassword(pass);
		u.setRole(role);
		u.setUserId(userId);
		u.setUsername(uname);
		u.setPhone(phone);

		HBMSService s = new HBMSService();
		Users USER = s.signUp(u);

		if (USER.equals("SUCCESS")) {
			req.getRequestDispatcher("/Home.jsp").forward(req, resp);
		} else {
			req.setAttribute("errMessage", USER);
			req.getRequestDispatcher("/Signup.jsp");
		}

	}
}
