package com.jsp.expenseTracker.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jsp.expenseTracker.entity.User;
import com.jsp.expenseTracker.service.UserService;
import com.jsp.expenseTracker.service.UserServiceImp;


@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	
	UserService userService = new UserServiceImp();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setFullname(request.getParameter("mobile"));
		user.setMobile(request.getParameter("password"));
		user.setUserId(Integer.parseInt(request.getParameter("id")));
		//to get Image Data
		Part part = request.getPart("imageFile");
		
		System.out.println(part.getName());
		System.out.println(part.getSize());
		System.out.println(part.getContentType());
		
		InputStream is = part.getInputStream();
		
		int status = userService.updateProfile(user, is);
		doGet(request, response);
	}

}
