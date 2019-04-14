package com.employee.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.system.service.EmpService;
import com.employee.systems.dev.dto.Employee;


public class DeleteServ extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		String empid=req.getParameter("Emp_ID");
		
		EmpService s = new EmpService();
//		Employee e=new Employee();
		
       boolean result=s.deleteserv(empid);
		

		HttpSession session;
		if (result =null != null)
		{
			session = req.getSession();
			session.setAttribute("Employee", result);

			req.getRequestDispatcher("/Delete.html").forward(req, resp);
		} else {

			req.getRequestDispatcher("/Login1.html").forward(req, resp);
		}
	} 
	}