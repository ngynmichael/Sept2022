package com.michael.serv;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;   
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")

public class DeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        try {
			EmployeeDAO.deleteUser(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        response.sendRedirect("ViewServlet");  
    }  
}  