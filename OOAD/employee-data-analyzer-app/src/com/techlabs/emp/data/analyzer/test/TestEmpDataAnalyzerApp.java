package com.techlabs.emp.data.analyzer.test;

import java.io.IOException;

import com.techlabs.emp.data.analyzer.Analyzer;
import com.techlabs.emp.data.analyzer.FileDataLoader;
import com.techlabs.emp.data.analyzer.IDataLoader;
import com.techlabs.emp.data.analyzer.Parser;
import com.techlabs.emp.data.analyzer.WebDataLoader;

public class TestEmpDataAnalyzerApp {

	public static void main(String[] args) {

		IDataLoader data=new WebDataLoader("https://swabhav-tech.firebaseapp.com/emp.txt");
		// IDataLoader data = new FileDataLoader("dataFile.txt");
		Parser parsedData = null;
		try {
			parsedData = new Parser(data);
		} catch (RuntimeException | IOException e) {
			e.printStackTrace();
		}

		Analyzer analyzer = new Analyzer(parsedData);

		System.out.println("Maximum Salaried Employee ->");
		System.out.println("Name: " + analyzer.maxSalariedEmployee().getName());
		System.out.println("Salary: " + analyzer.maxSalariedEmployee().getSalary() + "$");

		System.out.println("\nTotal No. of Employees: " + analyzer.getEmployeeCount());

		System.out.println("\nEmployee Count By Designation:\n" + analyzer.getEmployeeCountByDesignation());

		System.out.println("\nEmployee Count By Department:\n" + analyzer.getEmployeeCountByDepartment());

	}

}