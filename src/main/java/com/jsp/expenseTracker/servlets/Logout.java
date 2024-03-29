package com.jsp.expenseTracker.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. Access session object
		 * 2. Session is null vor not
		 * 3. Destroy session
		 * 4. Perform servlet chaining to display login page
		 */
		
		HttpSession session = request.getSession();
		if(session!=null)
		{
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
