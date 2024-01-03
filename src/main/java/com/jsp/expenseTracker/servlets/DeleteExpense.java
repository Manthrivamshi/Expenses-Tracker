package com.jsp.expenseTracker.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expenseTracker.entity.User;
import com.jsp.expenseTracker.service.ExpenseService;
import com.jsp.expenseTracker.service.ExpensesServiceImpl;

/**
 * Servlet implementation class DeleteExpense
 */
@WebServlet("/DeleteExpense")
public class DeleteExpense extends HttpServlet {
	private ExpenseService service = new ExpensesServiceImpl();
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Fetch Data from URL
		String temp = request.getParameter("expencesId");
		int expenseId = Integer.parseInt(temp);
		
		int status = service.deleteExpense(expenseId);
		
		if(status!=0) {
			HttpSession session = request.getSession();
			User  user=(User)session.getAttribute("userInfo");
			request.setAttribute("list", service.viewExpense(user.getUserId()));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewExpense.jsp");
			dispatcher.include(request, response);
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
