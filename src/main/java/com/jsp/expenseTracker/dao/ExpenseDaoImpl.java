package com.jsp.expenseTracker.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jsp.expenseTracker.entity.Expense;
import com.jsp.expenseTracker.utility.SingletonClass;

public class ExpenseDaoImpl implements ExpensesDao{

	private Connection connect = SingletonClass.getSingletonClassObject().getConnection();
	private PreparedStatement pstmt;
	
	@Override
	public int addExpense(Expense expense, int userId) throws Exception {
		String query = "insert into expences (amount, category, Description, date, userId)" +
				"values(?,?,?,?,?)";
		
		pstmt = connect.prepareStatement(query);
		pstmt.setDouble(1, expense.getAmount());
		pstmt.setString(2, expense.getCategory());
		pstmt.setString(3, expense.getDescription());
		pstmt.setDate(4, expense.getDate());
		pstmt.setInt(5, userId);
		
		int status = pstmt.executeUpdate();
		if(status!=0) {
			String selectQuery = "select Last_Insert_Id()";
			pstmt = connect.prepareStatement(selectQuery);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.isBeforeFirst()) {
				rs.next();
				int expenceId = rs.getInt(1);
				return expenceId;
			}
		}
		return 0;
		
	}

	@Override
	public List<Expense> viewExpense(int userId) throws Exception {
		
		String query = "select * from expences where userId = ?";
		pstmt = connect.prepareStatement(query);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		List<Expense>expensesList = new ArrayList<Expense>();
		if(rs.isBeforeFirst()) {
			while(rs.next()) {
				Expense expense = new Expense();
				expense.setAmount(rs.getDouble("amount"));
				expense.setDescription(rs.getString("Description"));
				expense.setDate(rs.getDate("date"));
				expense.setCategory(rs.getString("category"));
				//add expenseId
				expense.setExpenseId(rs.getInt("expencesId"));
				expensesList.add(expense);
				
			}

			return expensesList;
			
			
		}
		
		return null;
	}

	@Override
	public int deleteExpenseById(int expenseId) throws Exception {
		String query = "delete from expences where expencesId = ?";
		pstmt = connect.prepareStatement(query);
		pstmt.setInt(1, expenseId);
		int status = pstmt.executeUpdate();
		return status;
	}

	@Override
	public Expense findExpenseById(int expenseId) throws Exception {
		String query = "select * from expences where expencesId = ?";
		pstmt = connect.prepareStatement(query);
		pstmt.setInt(1, expenseId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.isBeforeFirst())
		{
			rs.next();
			Expense expense = new Expense();
			expense.setAmount(rs.getDouble("amount"));
			expense.setDate(rs.getDate("date"));
			expense.setCategory(rs.getString("category"));
			expense.setDescription(rs.getString("Description"));
			
			//add ExpenseId
			expense.setExpenseId(rs.getInt("expenseId"));
			return expense;
		}
		return null;
	}

	@Override
	public int updateExpense(Expense expense, int expenseId) throws Exception {
		
	String query = "update expences set amount=?,date=?,category=?,Description=?"
									+"where expencesId=?";
		pstmt = connect.prepareStatement(query);
		pstmt.setDouble(1, expense.getAmount());
		pstmt.setString(2, expense.getDescription());
		pstmt.setDate(3, expense.getDate());
		pstmt.setString(4, expense.getCategory());
		pstmt.setInt(5, expense.getExpenseId());
		
		int status = pstmt.executeUpdate();
		return status;
	}

	@Override
	public List<Expense> totalExpenseList(int userId, Date start, Date end) throws Exception {
		String query="select * from expences where date between ? and ?"+"and userId=?";
		pstmt=connect.prepareStatement(query);
		pstmt.setDate(1,start);
		pstmt.setDate(2,end);
		pstmt.setInt(3,userId);
		ResultSet rs = pstmt.executeQuery();
		List<Expense> expenseList = new ArrayList<Expense>();
		if(rs.isBeforeFirst()) {
			while(rs.next()) {
				Expense expense =new Expense();
				expense.setAmount(rs.getDouble("amount"));
				expense.setCategory(rs.getString("category"));
				expense.setDate(rs.getDate("date"));
				expense.setDescription(rs.getString("Description"));
				expense.setExpenseId(rs.getInt("expenseId"));
				expenseList.add(expense);
				
			}
			return expenseList;
		}
		return null;
	}

	
	@Override
	public List<Expense> filterExpenseByCategory(String category, int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
