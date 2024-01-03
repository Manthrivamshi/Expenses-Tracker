package com.jsp.expenseTracker.dao;

import java.io.InputStream;
import java.sql.SQLException;

import com.jsp.expenseTracker.entity.User;

//all database operation on User table
//Data Access object
public interface UserDao {
	
	//void register(String username, String fullname, String mobile, String email, String password);
		
		int register(User user) throws Exception;//return id of user after inserting data
		User login(String username, String password) throws Exception;
		
		String forgotPassword(String email) throws Exception;
		
		User findUserById(int id) throws Exception;
		
		int updateUserProfile(User user, InputStream is) throws Exception;
		
		byte[] getUserProfileImage(int userId) throws Exception;
}