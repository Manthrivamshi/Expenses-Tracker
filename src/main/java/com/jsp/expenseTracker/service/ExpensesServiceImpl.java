package com.jsp.expenseTracker.service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.jsp.expenseTracker.dao.ExpenseDaoImpl;
import com.jsp.expenseTracker.dao.ExpensesDao;
import com.jsp.expenseTracker.entity.Expense;

public class ExpensesServiceImpl implements ExpenseService{

	private ExpensesDao expensesDao = new ExpenseDaoImpl();
	
	@Override
	public int addExpense(Expense expense, int userId) {
		
		try {
			return expensesDao.addExpense(expense, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<Expense> viewExpense(int userId) {
		
		try {
			return expensesDao.viewExpense(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int deleteExpense(int expenseId) {
		try {
			return expensesDao.deleteExpenseById(expenseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateExpense(Expense expense, int expenseId) {
		try {
			return expensesDao.updateExpense(expense, expenseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Expense findExpenseById(int expenseId) {
		
		try {
			return expensesDao.findExpenseById( expenseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Expense> totalExpenseList(int userId, Date start, Date end) {
		
		
		try {
			return expensesDao.totalExpenseList(userId,start,end);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Expense> filterExpenseByCategory(String category, int userId) {
		
		try {
			return 
					expensesDao.filterExpenseByCategory(category,userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Expense> filterExpenseByAmountRange(int start, int end, int userId) {
		
		try {
			return expensesDao.viewExpense(userId).stream().filter(t -> t.getAmount() >= start && t.getAmount() <= end)
					.collect(Collectors.toList());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return null;
	}
	

}
