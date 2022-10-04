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
@WebServlet("/Register")
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("username");  
        String password=request.getParameter("password");  
          
        UserDAO bean=new UserDAO();  
          
        boolean status = false;
		try {
			status = bean.exists(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
        if(status){  
            out.print("Username Already Exists!!");
            RequestDispatcher rd=request.getRequestDispatcher("register.jsp");  
            rd.include(request, response);  
        }  
        else{
        	try {
				bean.insertUser(new User(name, password));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	out.print("New User Added Successfully!");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request, response);  
        }  
      
    }  
	
}