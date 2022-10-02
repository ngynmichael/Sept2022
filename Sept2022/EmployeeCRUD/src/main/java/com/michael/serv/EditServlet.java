package com.michael.serv;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;   
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") 

public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Employee e = new Employee();
		try {
			e = EmployeeDAO.selectUser(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");    
        out.print("<tr><td>Employee ID:</td><td><input type='number' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>First Name:</td><td><input type='text' name='firstName' value='"+e.getFirstName()+"'/> </td></tr>");  
        out.print("<tr><td>Last Name:</td><td><input type='text' name='lastName' value='"+e.getLastName()+"'/></td></tr>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  