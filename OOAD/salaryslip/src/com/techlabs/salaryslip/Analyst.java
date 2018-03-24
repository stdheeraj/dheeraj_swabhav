package com.techlabs.salaryslip;

public class Analyst extends Employee {

	private double perks;

	public Analyst(int id, String name, double basicsalary) {
		super(id, name, basicsalary);
		this.perks = 0.2 * basicsalary;
	}

	public String toString() {
		return (super.toString() + "\nPerks: " + this.getPerks() + "\nCTC: " + this
				.calcCTC());
	}

	@Override
	public double calcCTC() {
		return (this.perks + this.basicsalary);
	}

	public double getPerks() {
		return this.perks;
	}

}
