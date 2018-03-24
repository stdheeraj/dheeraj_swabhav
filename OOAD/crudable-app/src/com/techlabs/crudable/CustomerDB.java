package com.techlabs.crudable;

public class CustomerDB implements ICrudable {

	@Override
	public void create() {
		System.out.println("Customer created successfully");
	}

	@Override
	public void read() {
		System.out.println("Customer data read successfully");
	}

	@Override
	public void update() {
		System.out.println("Customer data updated successfully");
	}

	@Override
	public void delete() {
		System.out.println("Customer data deleted successfully");
	}

}
