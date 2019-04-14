package com.employee.system.controller;

import java.io.IOException;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.system.service.EmpService;
import com.employee.systems.dev.dto.Employee;

public class CreateServ extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		 resp.setContentType("text/html");
		 
		String empID=req.getParameter("Emp_ID");
		String empFirstName=req.getParameter("Emp_First_Name");
		String empLastName=req.getParameter("Emp_Last_Name");
		String empDateofBirth=req.getParameter("Emp_Date_of_Birth");
		String empDateofJoining=req.getParameter("Emp_Date_of_Joining");
		String empdeptid=req.getParameter("Emp_Dept_ID");
		String empGrade=req.getParameter("Emp_Grade");
		String empDesignation=req.getParameter("Emp_Designation");
		String empBasic=req.getParameter("Emp_Basic");
		String empGender=req.getParameter("Emp_Gender");
		String empMaritalStatus=req.getParameter("Emp_Marital_Status");
		String empHomeAddress=req.getParameter("Emp_Home_Address");
		String empContactNum=req.getParameter("Emp_Contact_Num");

		Employee e=new Employee();
	      
		e.setEmp_ID(empID);
		e.setEmp_First_Name(empFirstName);
		e.setEmp_Last_Name(empLastName);
		e.setEmp_Date_of_Birth(empDateofBirth);
		e.setEmp_Date_of_Joining(empDateofJoining);
	    e.setEmp_Dept_ID(empdeptid);
	    e.setEmp_Grade(empGrade);
	    e.setEmp_Designation(empDesignation);
	    e.setEmp_Basic(empBasic);
	    e.setEmp_Gender(empGender);
        e.setEmp_Marital_Status(empMaritalStatus);
        e.setEmp_Home_Address(empHomeAddress);
        e.setEmp_Contact_Num(empContactNum);

		EmpService s = new EmpService();
		boolean emp = s.createServ(e);
		
		HttpSession session;
		if (e!= null)
		{
			session = req.getSession();
			session.setAttribute("Employee", e);

			req.getRequestDispatcher("/register.html").forward(req, resp);
		} else {

			req.getRequestDispatcher("/Login1.html").forward(req, resp);
		}
	} 
}

