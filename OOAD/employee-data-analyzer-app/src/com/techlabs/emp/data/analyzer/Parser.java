package com.techlabs.emp.data.analyzer;

import java.io.IOException;
import java.util.HashSet;

public class Parser {

	private HashSet<Employee> employees;

	public Parser(IDataLoader dataloader) throws RuntimeException, IOException {
		this.employees = this.convertToEmpList(dataloader);
	}

	public HashSet<Employee> getEmployees() {
		return employees;
	}

	public HashSet<Employee> convertToEmpList(IDataLoader dataloader)
			throws RuntimeException, IOException {

		HashSet<Employee> emplist = new HashSet<Employee>();
		for (String data : dataloader.load()) {
			String[] empdata = data.split(",", 8);

			Employee emp = new Employee();
			emp.setId(Integer.parseInt(empdata[0]));
			emp.setName(empdata[1]);
			emp.setDesignation(empdata[2]);
			if (empdata[3].equals("NULL"))
				emp.setManagerId(0);
			else
				emp.setManagerId(Integer.parseInt(empdata[3]));
			emp.setDateOfJoining(empdata[4]);
			emp.setSalary(Integer.parseInt(empdata[5]));
			if (empdata[6].equals("NULL"))
				emp.setCommission(0);
			else
				emp.setCommission(Integer.parseInt(empdata[6]));
			emp.setDepartmentNumber(Integer.parseInt(empdata[7]));

			emplist.add(emp);
		}

		return emplist;
	}

}
