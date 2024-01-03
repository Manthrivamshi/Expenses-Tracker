package com.jsp.expenseTracker.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.expenseTracker.dao.UserDao;
import com.jsp.expenseTracker.dao.UserDaoImpl;
import com.jsp.expenseTracker.entity.User;
import com.jsp.expenseTracker.service.UserService;
import com.jsp.expenseTracker.service.UserServiceImp;

import java.util.Scanner;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * Fetch email from forgot password jsp file
		 * call forgotPassword() method from UserService interface
		 * perform servlet chaining
		 * Transfer data
		 *
		 */
		Scanner scan=new Scanner(System.in);
		String email=scan.next();
		
		UserService us=new UserServiceImp();
		String result=us.forgotPassword(email);
		if(result!=null)
		{
			System.out.println("Updated Record");
		}
		else
		{
			System.out.println("Please Provide Correct Email Id");
		}
	}

}
