package com.michael.serv;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.michael.serv.*;

public class EmployeeServlet extends HttpServlet{
	private EmployeeDAO employeeDAO;
	
	public void init() {
		employeeDAO = new EmployeeDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        doGet(request, response);
		    }

		    protected void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        String action = request.getServletPath();

		        try {
		            switch (action) {
		                case "/new":
		                    showNewForm(request, response);
		                    break;
		                case "/insert":
		                    insertUser(request, response);
		                    break;
		                case "/delete":
		                    deleteUser(request, response);
		                    break;
		                case "/edit":
		                    showEditForm(request, response);
		                    break;
		                case "/update":
		                    updateUser(request, response);
		                    break;
		                default:
		                    listUser(request, response);
		                    break;
		            }
		        } catch (SQLException ex) {
		            throw new ServletException(ex);
		        }
		    }
		    
		    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		    	List < Employee > listEmployee = employeeDAO.selectAllUsers();
		    	request.setAttribute("listEmployee", listEmployee);
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.html");
		    	dispatcher.forward(request, response);
		    }
		    
		    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.html");
		    	dispatcher.forward(request, response);
		    }
		    
		    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		    	int id = Integer.parseInt(request.getParameter("id"));
		    	Employee existingEmployee = employeeDAO.selectUser(id);
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.html");
		    	request.setAttribute("employee", existingEmployee);
		    	dispatcher.forward(request, response);

		    }
		    
		    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		    	int id = Integer.parseInt(request.getParameter("id"));
		    	String firstName = request.getParameter("firstName");
		    	String lastName = request.getParameter("lastName");
		    	Employee newUser = new Employee(id, firstName, lastName);
		    	employeeDAO.insertUser(newUser);
		    	response.sendRedirect("list");
		    }

		    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		    	int id = Integer.parseInt(request.getParameter("id"));
		    	String firstName = request.getParameter("firstName");
		    	String lastName = request.getParameter("lastName");

		    	Employee book = new Employee(id, firstName, lastName);
		    	employeeDAO.updateUser(book);
		    	response.sendRedirect("list");
		    }

		    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		    	int id = Integer.parseInt(request.getParameter("id"));
		    	employeeDAO.deleteUser(id);
		    	response.sendRedirect("list");

		    }
		    
		    
}
