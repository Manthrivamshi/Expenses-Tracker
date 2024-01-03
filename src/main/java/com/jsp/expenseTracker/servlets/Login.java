package com.jsp.expenseTracker.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expenseTracker.entity.User;
import com.jsp.expenseTracker.service.UserService;
import com.jsp.expenseTracker.service.UserServiceImp;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private UserService userService = new UserServiceImp();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//fetch data from login page
		String username = request.getParameter("username");
		System.out.println(username);
		String password = request.getParameter("password");
		System.out.println(password);
		
		User user = userService.login(username, password);
		
		
		PrintWriter writer = response.getWriter();
		//Access session object
		HttpSession session = request.getSession();
		
		if(user != null)
		{
			//cerdentials are valid  - show home page
			//to transefer data
			//request.setAttribute("userInfo", user);
			//transfer data with help of session
			
			session.setAttribute("userInfo", user);
			request.setAttribute("msg", "LOGIN SUCCESSFULL...!");
			
			RequestDispatcher dispatcher =request.getRequestDispatcher("Home.jsp");
			dispatcher.include(request, response);
			writer.print("Login successfull");
		}
		else
		{
			//Creadentials are invalid  - show page
			request.setAttribute("msg", "PLEASE ENTER VALID CRECENTAILS....");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
			writer.print("Invalid credentails");
		}
	}

}