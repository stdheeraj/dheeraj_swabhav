package com.techlabs.salaryslip;

public class Developer extends Employee {

	private double ta;
	private double pa;

	public Developer(int id, String name, double basicsalary) {
		super(id, name, basicsalary);
		this.ta = 0.3 * basicsalary;
		this.pa = 0.2 * basicsalary;
	}

	public String toString() {
		return (super.toString() + "\nTravel Allowance: " + this.getTA()
				+ "\nP Allowance:" + this.getPA() + "\nCTC: " + this.calcCTC());
	}

	@Override
	public double calcCTC() {
		return (this.basicsalary + this.ta + this.pa);
	}

	public double getTA() {
		return this.ta;
	}

	public double getPA() {
		return this.ta;
	}

}