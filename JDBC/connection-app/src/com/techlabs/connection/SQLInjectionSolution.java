package com.techlabs.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SQLInjectionSolution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:4040/techlabs",
							"root", "root");

			System.out.println("Enter dept no: ");
			String deptNo = sc.nextLine();

			String query = "SELECT * FROM DEPT WHERE deptno = ? ";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, deptNo);
			ResultSet rs = ps.executeQuery();

			System.out.println("   DNo - DName - Location");

			while (rs.next())
				System.out.println("-> " + rs.getString("DEPTNO") + " - "
						+ rs.getString("DNAME") + " - " + rs.getString("loc"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}