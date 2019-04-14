package com.employee.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.system.service.EmpService;
import com.employee.systems.dev.dto.Employee;
import com.employee.systems.dev.dto.Users;

public class UpdateServ extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String Empid=req.getParameter("Emp_id");
		String fname=req.getParameter("Emp_First_Name");
		String lname=req.getParameter("Emp_First_Name");
		String birthdate=req.getParameter("Emp_Date_of_Birth");
		String joindate=req.getParameter("Emp_Date_of_Joining");
		String designation=req.getParameter("Emp_Designation");
		String basic=req.getParameter("Emp_Basic");
		String gender=req.getParameter("Emp_Gender");
		String marital=req.getParameter("Emp_Marital_Status");
		String homeaddress=req.getParameter("Emp_Home_Address");
		String contact=req.getParameter("Emp_Contact_Num");
		
		
		
		
		
		Employee e=new Employee();
		
		e.setEmp_ID(Empid);
		e.setEmp_First_Name(fname);
		e.setEmp_Last_Name(lname);
		e.setEmp_Date_of_Birth(birthdate);
		e.setEmp_Date_of_Joining(joindate);
	    e.setEmp_Designation(designation);
	    e.setEmp_Basic(basic);
	    e.setEmp_Gender(gender);
        e.setEmp_Marital_Status(marital);
        e.setEmp_Home_Address(homeaddress);
        e.setEmp_Contact_Num(contact);
		
		
		
		
    	EmpService s = new EmpService();
		boolean emp = s.updateserv(e);
		
		HttpSession session;
		if (e!= null)
		{
			session = req.getSession();
			session.setAttribute("Employee", e);

			req.getRequestDispatcher("/update.html").forward(req, resp);
		} else {

			req.getRequestDispatcher("/Login1.html").forward(req, resp);
		}
	} 
}
