package com.michael.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.michael.model.*;

@SuppressWarnings("serial")
@WebServlet("/DeleteProduct")
public class DeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
		try {
			ProductDAO.deleteProduct(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        response.sendRedirect("main.jsp");  
	}
}
