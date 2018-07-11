package com.techlabs.mssql.connection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {
		
		Connection con = null;  
	    
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:49800;DatabaseName=aurionpro;integratedsecurity=true");

			System.out.println(con.getClass());
			
			System.out.println("Database name: " + con.getCatalog());

			DatabaseMetaData meta = con.getMetaData();
			System.out.println("Server name: " + meta.getDatabaseProductName());
			System.out.println("Server version: "
					+ meta.getDatabaseProductVersion());
			System.out.println("Driver name: " + meta.getDriverName());
			System.out.println("Driver version: " + meta.getDriverVersion());
			System.out.println("JDBC major version: "
					+ meta.getJDBCMajorVersion());
			System.out.println("JDBC minor version: "
					+ meta.getJDBCMinorVersion());

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {  
	         if (con != null) try { con.close(); } catch(Exception e) {}  
	      }

	}

}
