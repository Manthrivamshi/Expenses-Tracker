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
 * Servlet implementation class updateExpense
 */
@WebServlet("/updateExpense")
public class updateExpense extends HttpServlet {
	
	private ExpenseService service = new ExpensesServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetch expense information - amount, date , category, description
		int expenseId=Integer.parseInt(request.getParameter("eid"));
		//store all expense info in Expense object 
		Expense expense = new Expense();
		expense.setAmount(Double.parseDouble(request.getParameter("amount")));
		expense.setDate(Date.valueOf(request.getParameter("date")));
		expense.setDescription(request.getParameter("Description"));
		
		//call update expense method
		int status = service.updateExpense(expense, expenseId);
		
		//return 1 - then display viewExpense.jsp
		//return 0 - then display updateExpense.jsp
		if(status!=0)
		{
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("userInfo");
			List<Expense> expenses = service.viewExpense(user.getUserId());
			request.setAttribute("list", expenses);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewExpense.jsp");
			dispatcher.include(request, response);
		}
		else
		{
			request.setAttribute("msg", "please enter invalid details");
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateExpense.jsp");
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
