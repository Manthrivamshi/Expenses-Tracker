package com.jsp.expenseTracker.dao;

import java.sql.Date;
import java.util.List;

import com.jsp.expenseTracker.entity.Expense;

public interface ExpensesDao {

	int addExpense(Expense expense, int userId) throws Exception;
	
	List<Expense> viewExpense(int userId)throws Exception;
	
	int deleteExpenseById(int expenseId) throws Exception;
	
	Expense findExpenseById(int expenseId)throws Exception;
	
	int updateExpense(Expense expense, int expenseId) throws Exception;
	

	List<Expense> totalExpenseList(int userId, Date start, Date end) throws Exception;

	List<Expense> filterExpenseByCategory(String category, int userId) throws Exception;


}

