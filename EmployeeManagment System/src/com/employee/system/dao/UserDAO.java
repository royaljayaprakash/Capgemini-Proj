package com.employee.system.dao;

import com.employee.systems.dev.dto.Employee;
import com.employee.systems.dev.dto.Users;

public interface UserDAO 
{
	public Users login(String userId, String password);
	public Employee create(Employee e);
	public Employee update(Employee e);
	public Employee delete( String Emp_ID);
	public boolean listAll(Employee e);
}
