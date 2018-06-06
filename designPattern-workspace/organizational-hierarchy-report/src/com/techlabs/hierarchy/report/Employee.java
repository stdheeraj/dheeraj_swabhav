package com.techlabs.hierarchy.report;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private int id;
	private String name;
	private String designation;
	private int managerId;
	private String dateOfJoining;
	private int salary;
	private int commission;
	private int departmentNumber;
	private List<Employee> reportees;

	public Employee(EmployeeDTO employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.designation = employee.getDesignation();
		this.managerId = employee.getManagerId();
		this.dateOfJoining = employee.getDateOfJoining();
		this.salary = employee.getSalary();
		this.commission = employee.getCommission();
		this.departmentNumber = employee.getDepartmentNumber();
		this.reportees = new ArrayList<Employee>();
	}
	
	public void addReportee(Employee reportee){
		this.reportees.add(reportee);
	}
	
	public List<Employee> getReportees() {
		return reportees;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}

	public int getManagerId() {
		return managerId;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public int getSalary() {
		return salary;
	}

	public int getCommission() {
		return commission;
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
