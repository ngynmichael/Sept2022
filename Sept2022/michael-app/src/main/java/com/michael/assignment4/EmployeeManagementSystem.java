package com.michael.assignment4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManagementSystem {

	public static void main(String[] args) throws SQLException {
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sept2022", "root", "Wildpho159492");
				PreparedStatement pst = 
						con.prepareStatement("create table employees(empID numeric(10), firstName varchar(255), lastName varchar(255), primary key(empID))")){
				if(tableExists(con, "employees") == false) {
					pst.execute();
				}
				Scanner sc = new Scanner(System.in);
				System.out.println("Welcome to the Employee Managment System!");
				System.out.println("Would you like to add, update, delete, or search for an employee?");
				String choice = sc.nextLine();
				switch(choice.toLowerCase().replaceAll("\\s", "")) {
					case("add"):
					case("addanemployee"):
					case("addemployee"):
						System.out.println("Please enter the employee's ID number: ");
						int id = sc.nextInt();
						sc.nextLine();
						System.out.println("Please enter the employee's first name: ");
						String first = sc.nextLine();
						System.out.println("Please enter the employee's last name: ");
						String last = sc.nextLine();
						add(con, id, first, last);
						break;
					case("update"):
					case("updateanemployee"):
					case("updateemployee"):
						System.out.println("Please enter the employee's ID number: ");
						id = sc.nextInt();
						sc.nextLine();
						System.out.println("Please enter the employee's first name: ");
						first = sc.nextLine();
						System.out.println("Please enter the employee's last name: ");
						last = sc.nextLine();
						System.out.println("Please enter the employee's new ID number: ");
						int newId = sc.nextInt();
						sc.nextLine();
						System.out.println("Please enter the employee's new first name: ");
						String newFirst = sc.nextLine();
						System.out.println("Please enter the employee's new last name: ");
						String newLast = sc.nextLine();
						update(con, id, first, last, newId, newFirst, newLast);
						break;
					case("delete"):
					case("deleteanemployee"):
					case("deleteemployee"):
						System.out.println("Please enter the employee's ID number: ");
						id = sc.nextInt();
						sc.nextLine();
						System.out.println("Please enter the employee's first name: ");
						first = sc.nextLine();
						System.out.println("Please enter the employee's last name: ");
						last = sc.nextLine();
						delete(con, id, first, last);
						break;
					case("search"):
					case("searchforanemployee"):
					case("searchemployee"):
						System.out.println("Please enter the employee's ID number: ");
						id = sc.nextInt();
						sc.nextLine();
						System.out.println("Please enter the employee's first name: ");
						first = sc.nextLine();
						System.out.println("Please enter the employee's last name: ");
						last = sc.nextLine();
						search(con, id, first, last);
						break;
						
				}
				} catch(SQLException e) {
					
				}
	}
	
	public static void add(Connection con, int empID, String firstName, String lastName) throws SQLException {
		PreparedStatement p = con.prepareStatement("insert into employees(empID, firstName, lastName) values(?, ?, ?)");
		p.setInt(1, empID);
		p.setString(2, firstName);
		p.setString(3,  lastName);
		p.executeUpdate();
		System.out.println("Employee added successfully!");
	}
	
	public static void update(Connection con, int empID, String firstName, String lastName, int newEmpID, String newFirstName, String newLastName) throws SQLException {
		PreparedStatement p = con.prepareStatement("update employees set empID = ?, firstName = ?, lastName = ? where empID = ? and firstName = ? and lastName = ?");
		p.setInt(1, newEmpID);
		p.setString(2, newFirstName);
		p.setString(3, newLastName);
		p.setInt(4, empID);
		p.setString(5, firstName);
		p.setString(6, lastName);
		p.executeUpdate();
		System.out.println("Employee updated successfully!");
	}
	
	public static void delete(Connection con, int empID, String firstName, String lastName) throws SQLException {
		PreparedStatement p = con.prepareStatement("delete from employees where empID = ? and firstName = ? and lastName = ?");
		p.setInt(1, empID);
		p.setString(2, firstName);
		p.setString(3, lastName);
		p.executeUpdate();
		System.out.println("Employee deleted successfully!");
	}
	
	public static void search(Connection con, int empID, String firstName, String lastName) throws SQLException {
		PreparedStatement p = con.prepareStatement("select * from employees where empID = ? and firstName = ? and lastName = ?");
		p.setInt(1, empID);
		p.setString(2, firstName);
		p.setString(3, lastName);
		ResultSet rs1 = p.executeQuery();
		System.out.println("EMPID        FIRST NAME        LAST NAME");
		while (rs1.next()) {
			int employeeID = rs1.getInt(1);
			String employeeFirst = rs1.getString(2);
			String employeeLast = rs1.getString(3);
			System.out.println(employeeID + "        " + employeeFirst + "        " + employeeLast);

		}
	}
	
	public static boolean tableExists(Connection con, String tableName) throws SQLException{
		DatabaseMetaData meta = con.getMetaData();
		ResultSet resultSet = meta.getTables(null,  null, tableName, new String[]{"TABLE"});
		return resultSet.next();
	}
}