package com.jsp.expenseTracker.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expenseTracker.entity.Expense;
import com.jsp.expenseTracker.entity.User;
import com.jsp.expenseTracker.service.ExpenseService;
import com.jsp.expenseTracker.service.ExpensesServiceImpl;

/**
 * Servlet implementation class viewExpenses
 */
@WebServlet("/viewExpenses")
public class viewExpenses extends HttpServlet {
	
	private ExpenseService expenseService = new ExpensesServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Fetch User object from session
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userInfo");
		
		
		List<Expense> listOfExpense = expenseService.viewExpense(user.getUserId());
		
		request.setAttribute("list", listOfExpense);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewExpense.jsp");
		dispatcher.include(request, response);
	
	}

}
