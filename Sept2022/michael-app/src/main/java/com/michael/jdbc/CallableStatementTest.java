package com.michael.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CallableStatementTest {

	public static void main(String[] args) throws SQLException {
		// try with resources block
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sept2022", "root", "Wildpho159492");
				CallableStatement cst = con.prepareCall("{call getEmp(?, ?, ?)}")) {
			cst.setInt(1, 101  );
			cst.registerOutParameter(2, java.sql.Types.VARCHAR);
			cst.registerOutParameter(3, java.sql.Types.VARCHAR);
			cst.executeUpdate();
			
			String empName = cst.getString(2);
			String empAddress = cst.getString(3);
			System.out.println(empName);
			System.out.println(empAddress);
			
		}
	}
}