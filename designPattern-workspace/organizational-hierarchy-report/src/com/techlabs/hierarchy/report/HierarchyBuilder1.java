package com.techlabs.hierarchy.report;

import java.util.HashSet;

public class HierarchyBuilder1 {
	
	private HashSet<Employee> empList;

	public HierarchyBuilder1(Parser parsedData) {
		
		empList = new HashSet<Employee>();
		
		for (EmployeeDTO employee : parsedData.getEmployees()) {
			empList.add(new Employee(employee));
		}
	}
	
	private Employee getCEO(){
		for (Employee employee : this.empList) {
			if(employee.getManagerId()==0)
				return employee;
		}
		
		return null;
	}
	
	public Employee buildHierarchy(){
		
		Employee ceo = getCEO();
		
		for (Employee employee : this.empList) {
			if(employee.getManagerId()==ceo.getId())
				ceo.addReportee(employee);
		}
		
		for (Employee employee : this.empList) {
			for (Employee ceoReportee : ceo.getReportees()) {
				if(employee.getManagerId()==ceoReportee.getId())
					ceoReportee.addReportee(employee);
			}
			
		}
		
		return ceo;
	}

}
