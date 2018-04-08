package com.techlabs.enggcollege;

public class Student extends Person {

	private Branch branch;

	public Student(int id, String address, String dob, Branch branch) {
		super(id, address, dob);
		this.branch = branch;
	}

	public Branch getBranch() {
		return branch;
	}

}
