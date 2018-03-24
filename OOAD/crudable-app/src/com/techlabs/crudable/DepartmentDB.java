package com.techlabs.crudable;

public class DepartmentDB implements ICrudable {

	@Override
	public void create() {
		System.out.println("Department data created successfully");
	}

	@Override
	public void read() {
		System.out.println("Department data read successfully");
	}

	@Override
	public void update() {
		System.out.println("Department data updated successfully");
	}

	@Override
	public void delete() {
		System.out.println("Department data deleted successfully");
	}

}
