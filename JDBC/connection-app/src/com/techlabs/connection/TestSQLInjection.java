package com.techlabs.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TestSQLInjection {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:4040/techlabs?allowMultiQueries=true&", "root", "root");

			Statement s = con.createStatement();
			
			System.out.println("Enter dept no: ");
			String deptNo = sc.nextLine();
			
			ResultSet rs = s.executeQuery("select * from DEPT where deptno = "+deptNo);

			System.out.println("   DNo - DName - Location");

			while (rs.next())
				System.out.println("-> "+rs.getString("DEPTNO") + " - "
						+ rs.getString("DNAME") + " - "
						+ rs.getString("loc"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sc.close();
		}

	}

}
