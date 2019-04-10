package com.caps.dev.controller.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caps.dev.model.beans.Users;

@WebServlet("/homepage")
public class HomeServ extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session != null) {

			Users s = (Users) session.getAttribute("Users");
			req.getRequestDispatcher("/Home.jsp").forward(req, resp);
		} else {

		}
	}

}
