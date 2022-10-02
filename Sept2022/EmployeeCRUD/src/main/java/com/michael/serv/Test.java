package com.michael.serv;

import java.sql.SQLException;

import com.michael.serv.*;

public class Test {
	
	public static void main(String[] args) throws SQLException {
//		EmployeeDAO.createDB();
		Employee mike = new Employee(144, "Mike", "Winn");
		System.out.println(EmployeeDAO.selectUser(123456));
		
	}
}
