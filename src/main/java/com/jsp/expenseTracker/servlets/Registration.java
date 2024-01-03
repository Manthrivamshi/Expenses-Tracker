package com.jsp.expenseTracker.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import com.jsp.expenseTracker.entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.expenseTracker.service.UserService;
import com.jsp.expenseTracker.service.UserServiceImp;

@WebServlet("/Registration")
public class Registration extends HttpServlet{
	
	private UserService service = new UserServiceImp();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//fetch data from HTML Form
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String cnpassword = request.getParameter("cnpassword");
		
		//store data in user object 
		User user = new User();
		user.setFullname(fullname);
		user.setUsername(username);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPassword(password);
		
		//call register method from UserService
		int userId = service.register(user, cnpassword);
		
		//print output on the browser
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		if(userId!=0)
		{
			//Display Login.jsp file
			RequestDispatcher dispatcher = request.getRequestDispatcher("logIn.jsp");
			//to complete servlet chaining
			dispatcher.include(request, response);
			writer.print("<h1 style='color:green;'>Registration successfull!!!</h1>");
			writer.print("<h1 style='color:blue;'>Your userId = "+userId + "</h1>");
		}
		else {
			//display Register.jsp file
			RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
			dispatcher.include(request, response);
			writer.print("<h1 style='color:red;'>Please enter valid details</h1>");
		}
		
		
	}
	
	
}
