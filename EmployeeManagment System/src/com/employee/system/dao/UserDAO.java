package com.employee.system.dao;

import com.employee.systems.dev.dto.Employee;
import com.employee.systems.dev.dto.Users;

public interface UserDAO 
{
	public Users login(String userId, String password);
	public boolean create(Employee e);
	public boolean update(Employee e);
	public boolean delete( String Emp_ID);
	public void listAll(Employee e);
}
