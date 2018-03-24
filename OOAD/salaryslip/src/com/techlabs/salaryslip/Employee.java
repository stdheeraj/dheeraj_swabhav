package com.techlabs.salaryslip;

public abstract class Employee {
	
	private int id;
	private String name;
	protected double basicsalary;
	
	public Employee(int id, String name, double basicsalary){
		this.id=id;
		this.name=name;
		this.basicsalary=basicsalary;
	}
	
	public String toString(){
		return ("\nName: "+this.name+"\nBasic Salary: "+this.basicsalary);
	}
	
	public abstract double calcCTC();

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBasicSalary(){
		return basicsalary;
	}

}
