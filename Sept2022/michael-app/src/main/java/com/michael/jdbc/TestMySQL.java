package com.michael.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMySQL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Load the MySQL driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Create a Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sept2022", "root", "Wildpho159492");
		//Create a Statement
		Statement st = con.createStatement();
		st.execute("create table emp(eno numeric(10), ename varchar(50), esal numeric(10), primary key(eno))");
		st.execute("insert into emp values(100, 'Rebecca', 12345)");
		st.execute("insert into emp values(101, 'Jayden', 54321)");
		st.execute("insert into emp values(102, 'Jethon', 22222)");
		st.execute("insert into emp values(103, 'Adam', 44444)");
		st.execute("insert into emp values(104, 'Dummy', 12345)");
		
		st.execute("update emp set esal=33333 where eno=102");
		st.execute("delete from emp where eno=104");
		ResultSet rs = st.executeQuery("select * from emp");
		while(rs.next()) {
			System.out.println("Emp No " + rs.getInt("eno"));
			System.out.println("Emp Name " + rs.getString(2));
			System.out.println("Emp Sal " + rs.getInt("esal"));
		}
		
	}
}
