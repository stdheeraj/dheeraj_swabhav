package com.techlabs.mssql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestStatement {

	public static void main(String[] args) {

		String connectionUrl = "jdbc:sqlserver://localhost:49800;DatabaseName=aurionpro;integratedsecurity=true";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			String SQL = "select * from DEPT";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			
			System.out.println("DNo\tDName\tLocation");

			while (rs.next())
				System.out.println(rs.getString("DEPTNO")+"\t\t"+rs.getString("DNAME")+"\t\t"+rs.getString("loc"));

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

	}

}
