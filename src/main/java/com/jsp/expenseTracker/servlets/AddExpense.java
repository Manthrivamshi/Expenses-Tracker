package com.jsp.expenseTracker.servlets;

import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class AddExpense
 */
@WebServlet("/AddExpense")
public class AddExpense extends HttpServlet {
	
	private ExpenseService expenseService = new ExpensesServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Fetch data from HTML form and store in Expense object
		Expense expense = new Expense();
		expense.setAmount(Double.parseDouble(request.getParameter("amount")));
		expense.setDescription(request.getParameter("description"));
		expense.setDate(Date.valueOf(request.getParameter("date")));
		expense.setCategory(request.getParameter("category"));
		
		//get userId of an user, who logged in the application
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userInfo");
		
		int expenseId = expenseService.addExpense(expense, user.getUserId());
		
		//PrintWriter writer  = response.getWriter();
		//writer.print("<h1>Expense added Successfully, ExpenseId = "+expenseId+"</h1>");
		if(expenseId!=0) {
			//call viewExpense method -> ExpenseService
			List<Expense> list = expenseService.viewExpense(user.getUserId());
			request.setAttribute("list", list);
			RequestDispatcher dispatcher=request.getRequestDispatcher("viewExpense.jsp");
			dispatcher.include(request, response);
			
		}
		else {
			request.setAttribute("msg", "please enter valid details");
			//servlet chaining --> to display AddExpense.jsp File
		}
		
	}

}
