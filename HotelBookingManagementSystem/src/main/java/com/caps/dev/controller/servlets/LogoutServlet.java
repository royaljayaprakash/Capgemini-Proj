package com.caps.dev.controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if (session != null) {
			session.invalidate();
			Cookie[] cookies = req.getCookies();
			for (Cookie c : cookies) {
				if (c.getName().equals("JSESSIONID")) {
					c.setMaxAge(0);
					resp.addCookie(c);
				}
			}
		} else {
			
			req.getRequestDispatcher("/Signup.jsp");
		}

	}

}
