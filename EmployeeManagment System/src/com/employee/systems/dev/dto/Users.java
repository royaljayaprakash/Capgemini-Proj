package com.employee.systems.dev.dto;

public class Users 
{
		private String userId;
		private String username;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getUserPassword() {
			return UserPassword;
		}
		public void setUserPassword(String userPassword) {
			UserPassword = userPassword;
		}
		public String getUserType() {
			return UserType;
		}
		public void setUserType(String userType) {
			UserType = userType;
		}
		private String UserPassword;
		private String UserType;
		@Override
		public String toString() {
			return "Users [userId=" + userId + ", username=" + username + ", UserPassword=" + UserPassword
					+ ", UserType=" + UserType + "]";
		}

}
