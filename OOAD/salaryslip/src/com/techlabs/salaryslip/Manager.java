package com.techlabs.salaryslip;

public class Manager extends Employee {

	private double hra;
	private double da;
	private double ta;

	public Manager(int id, String name, double basicsalary) {
		super(id, name, basicsalary);
		this.hra = 0.5 * basicsalary;
		this.da = 0.4 * basicsalary;
		this.ta = 0.3 * basicsalary;
	}

	public String toString() {
		return (super.toString() + "\nHR Allowance: " + this.getHRA()
				+ "\nD Allowance:" + this.getDA() + "\nTravel Allowance:"
				+ this.getTA() + "\nCTC: " + this.calcCTC());
	}

	@Override
	public double calcCTC() {
		return (this.hra + this.da + this.ta + this.basicsalary);
	}

	public double getHRA() {
		return this.hra;
	}

	public double getDA() {
		return this.da;
	}

	public double getTA() {
		return this.ta;
	}

}
