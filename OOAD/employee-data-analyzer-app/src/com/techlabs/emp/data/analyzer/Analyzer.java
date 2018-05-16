package com.techlabs.emp.data.analyzer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Analyzer {

	private HashSet<Employee> empList;

	public Analyzer(Parser parsedData) {
		this.empList = parsedData.getEmployees();
	}

	public Employee maxSalariedEmployee() {

		int maxSalary = 0;
		Employee maxSalariedEmp = null;

		for (Employee emp : empList) {
			if (emp.getSalary() > maxSalary) {
				maxSalariedEmp = emp;
				maxSalary = emp.getSalary();
			}
		}

		return maxSalariedEmp;

	}

	public int getEmployeeCount() {
		return empList.size();
	}

	public Map<String, Integer> getEmployeeCountByDesignation() {

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (Employee emp : empList) {
			if (!map.containsKey(emp.getDesignation()))
				map.put(emp.getDesignation(), 1);
			else
				map.put(emp.getDesignation(), map.get(emp.getDesignation()) + 1);
		}

		return map;

	}

	public Map<Integer, Integer> getEmployeeCountByDepartment() {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (Employee emp : empList) {
			if (!map.containsKey(emp.getDepartmentNumber()))
				map.put(emp.getDepartmentNumber(), 1);
			else
				map.put(emp.getDepartmentNumber(),
						map.get(emp.getDepartmentNumber()) + 1);
		}

		return map;

	}

}
