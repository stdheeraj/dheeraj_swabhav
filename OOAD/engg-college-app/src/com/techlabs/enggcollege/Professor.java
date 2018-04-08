package com.techlabs.enggcollege;

public class Professor extends Person implements SalariedEmployee {

	private int workinghours;

	public Professor(int id, String address, String dob, int workinghours) {
		super(id, address, dob);
		this.workinghours = workinghours;
	}

	public int getWorkinghours() {
		return workinghours;
	}

	@Override
	public long calSalary() {
		return this.getWorkinghours() * 30 * 900;
	}

}
