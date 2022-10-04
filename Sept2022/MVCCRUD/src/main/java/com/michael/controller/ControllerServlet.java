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
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("username");  
        String password=request.getParameter("password");  
          
        UserDAO bean=new UserDAO();  
          
        boolean status = false;
		try {
			status = bean.validate(name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
          
        if(status){  
            RequestDispatcher rd=request.getRequestDispatcher("main.jsp");  
            rd.forward(request, response);  
        }  
        else{  
            RequestDispatcher rd=request.getRequestDispatcher(".jsp");  
            rd.forward(request, response);  
        }  
      
    }  
  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        doPost(req, resp);  
    }  
}  
