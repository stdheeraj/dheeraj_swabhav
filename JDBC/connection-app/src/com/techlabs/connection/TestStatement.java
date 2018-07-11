package com.techlabs.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestStatement {

	public static void main(String[] args) {
		
		try {
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/techlabs", "root", "root");
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from DEPT");
			
			System.out.println("DNo\tDName\tLocation");
			
			while(rs.next()) 
			    System.out.println(rs.getString("DEPTNO")+"\t\t"+rs.getString("DNAME")+"\t\t"+rs.getString("loc"));  
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
