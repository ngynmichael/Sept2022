package com.michael.serv;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@SuppressWarnings("serial")

public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String firstName=request.getParameter("firstName");  
        String lastName=request.getParameter("lastName");  
          
        Employee e=new Employee();  
        e.setId(id);  
        e.setFirstName(firstName);  
        e.setLastName(lastName);    
          
        int status = 0;
		try {
			status = EmployeeDAO.updateUser(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  