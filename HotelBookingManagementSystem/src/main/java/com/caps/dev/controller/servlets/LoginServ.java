package com.caps.dev.controller.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.caps.dev.model.beans.Users;

import com.caps.dev.model.dao.UserDAO;
import com.caps.dev.services.HBMSService;

@WebServlet("/LoginProfile")
public class LoginServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
		String password = req.getParameter("password");

		HBMSService s = new HBMSService();
		Users USER = s.loginService(userId, password);

		HttpSession session;
		if (USER != null) {
			session = req.getSession();
			session.setAttribute("Users", USER);

			req.getRequestDispatcher("/images.jsp").forward(req, resp);
		} else {

			req.getRequestDispatcher("/LoginProfile.jsp").forward(req, resp);
		}
	}
}
