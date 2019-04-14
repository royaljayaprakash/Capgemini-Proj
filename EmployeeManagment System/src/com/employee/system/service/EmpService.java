package com.employee.system.service;
import com.employee.system.dao.JDBCImpl;
import com.employee.system.dao.UserDAO;
import com.employee.systems.dev.dto.Employee;
import com.employee.systems.dev.dto.Users;

public class EmpService 
{
	public Users loginService(String userId, String password)
	{
		UserDAO db = new JDBCImpl();
		Users USER = db.login(userId, password);
		return USER;
	}
	public boolean createServ(Employee e) 
	{
		boolean result=false;
		UserDAO db = new JDBCImpl(); 
		result=db.create(e);
	         return result;
       }
	
	public boolean  deleteserv( String Emp_ID)
	{
		 
	     {
	    		boolean result=false;
	    	 UserDAO db = new JDBCImpl(); 
	    	 result =db.delete(Emp_ID);
	    	 
	    	 return result;
	     }
		
	}
	
	public boolean  updateserv( Employee e)
	{
		 
	     {
	    	 
	    		boolean result=false;
	    	 UserDAO db = new JDBCImpl(); 
	    	 result=db.update(e);
	    	 
	    	 return result;
	     }
		
	}
	
	}
