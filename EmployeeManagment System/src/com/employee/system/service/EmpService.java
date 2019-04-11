package com.employee.system.service;

import com.employee.system.dao.JDBCImpl;
import com.employee.system.dao.UserDAO;
import com.employee.systems.dev.dto.Users;

public class EmpService {
	public Users loginService(String userId, String password)
	{
		UserDAO db = new JDBCImpl();
		Users USER = db.login(userId, password);
		return USER;
}
}
