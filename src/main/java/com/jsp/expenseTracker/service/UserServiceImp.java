package com.jsp.expenseTracker.service;

import java.io.InputStream;
import java.sql.SQLException;

import com.jsp.expenseTracker.dao.UserDao;
import com.jsp.expenseTracker.dao.UserDaoImpl;
import com.jsp.expenseTracker.entity.User;

public class UserServiceImp implements UserService{
	
	private UserDao userdao = new UserDaoImpl();
	@Override
	public int register(User user, String cpassword) {
		if(user.getPassword().equals(cpassword)) {
			try {
				int userId = userdao.register(user);
				System.out.println("Service layer UserId = "+userId);
				return userId;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	@Override
	public User login(String username, String password) {
		try {
			return userdao.login(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String forgotPassword(String email) 
	{
		
		
		/* 1. call forgotPassword method - UserDao interface
		 * 2. Handle exception
		 * 3. return respective data
		 */
		try 
		{
			return userdao.forgotPassword(email);
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User findByUserId(int userId) {
		try {
			return userdao.findUserById(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int updateProfile(User user, InputStream is) {
		try {
		return	userdao.updateUserProfile(user, is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public byte[] getUserProfileImage(int userId) {
		try {
			return userdao.getUserProfileImage(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
