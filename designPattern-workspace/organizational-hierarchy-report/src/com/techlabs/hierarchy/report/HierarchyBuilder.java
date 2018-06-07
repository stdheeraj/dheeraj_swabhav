package com.techlabs.hierarchy.report;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HierarchyBuilder {
	
	private Employee ceo;
	private HashSet<Employee> empList;

	public HierarchyBuilder(Parser parsedData) {
		empList = new HashSet<Employee>();
		
		for (EmployeeDTO employee : parsedData.getEmployees()) {
			empList.add(new Employee(employee));
		}
		
		for (Employee emp : this.empList) {
			if(emp.getManagerId()==0)
				this.ceo = emp;
		} 
	}
	
	public Employee getCEO(){
		return ceo;
	}
	
	public Map<Integer, Employee> buildHierarchy(){
		
		Map<Integer, Employee> mapEmpList = new HashMap<Integer, Employee>();
		
		for (Employee emp : empList) {
			if (!mapEmpList.containsKey(emp.getId()))
				mapEmpList.put(emp.getId(), emp);
		}
		
		for (Employee emp : empList) {
			if (mapEmpList.containsKey(emp.getManagerId()))
				mapEmpList.get(emp.getManagerId()).addReportee(emp);
		}
		
		/*
		for (Employee emp : empList) {
			
			if (!mapEmpList.containsKey(emp.getId()))
				mapEmpList.put(emp.getId(), emp);
			else{
				emp.setReportee(mapEmpList.get(emp).getReportees());
				mapEmpList.put(emp.getId(), emp);
			}
			
			if (mapEmpList.containsKey(emp.getManagerId()))
				mapEmpList.get(emp.getManagerId()).addReportee(emp);
			else if(emp.getManagerId()==0)
				continue;
			else
				mapEmpList.put(emp.getManagerId(), new Employee(new EmployeeDTO()));
			
		}
		
		for (Employee employee : this.empList) {
			if(employee.getManagerId()==this.ceo.getId())
				this.ceo.addReportee(employee);
		}
		
		for (Employee employee : this.empList) {
			for (Employee ceoReportee : this.ceo.getReportees()) {
				if(employee.getManagerId()==ceoReportee.getId())
					ceoReportee.addReportee(employee);
			}
			
		}
		*/
		
		return mapEmpList;
	}

}
