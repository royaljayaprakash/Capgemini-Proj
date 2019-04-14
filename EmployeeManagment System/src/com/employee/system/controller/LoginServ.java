package com.employee.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.system.service.EmpService;
import com.employee.systems.dev.dto.Users;



public class LoginServ extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	String userId = req.getParameter("userId");
	String password = req.getParameter("password");

	EmpService s = new EmpService();
	Users USER = s.loginService(userId, password);

	HttpSession session;
	if (USER != null)
	{
		session = req.getSession();
		session.setAttribute("Users", USER);

		req.getRequestDispatcher("/ProjectHeader.html").forward(req, resp);
	} else {

		req.getRequestDispatcher("/Login1.html").forward(req, resp);
	}
}

}

