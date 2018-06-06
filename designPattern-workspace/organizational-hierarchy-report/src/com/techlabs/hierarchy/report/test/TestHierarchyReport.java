package com.techlabs.hierarchy.report.test;

import java.io.IOException;

import com.techlabs.hierarchy.report.Employee;
import com.techlabs.hierarchy.report.FileDataLoader;
import com.techlabs.hierarchy.report.HierarchyBuilder;
import com.techlabs.hierarchy.report.IDataLoader;
import com.techlabs.hierarchy.report.Parser;

public class TestHierarchyReport {

	public static void main(String[] args) {

		//IDataLoader data=new WebDataLoader("https://swabhav-tech.firebaseapp.com/emp.txt");
		IDataLoader data = new FileDataLoader("dataFile.txt");
		Parser parsedData = null;
		try {
			parsedData = new Parser(data);
		} catch (RuntimeException | IOException e) {
			e.printStackTrace();
		}
		
		HierarchyBuilder hbuilder=new HierarchyBuilder(parsedData);
		Employee ceo = hbuilder.buildHierarchy();
		
		System.out.println(ceo.getDesignation()+"("+ceo.getName()+")");
		for (Employee emp : ceo.getReportees()) {
			System.out.println("\t\t"+emp.getDesignation()+"("+emp.getName()+")");
			for (Employee employee : emp.getReportees()) {
				System.out.println("\t\t\t\t"+employee.getDesignation()+"("+employee.getName()+")");
			}
		}
		

	}

}