package com.techlabs.crudable;

public class InvoiceDB implements ICrudable {

	@Override
	public void create() {
		System.out.println("Invoice created successfully");
	}

	@Override
	public void read() {
		System.out.println("Invoice data read successfully");
	}

	@Override
	public void update() {
		System.out.println("Invoice data updated successfully");
	}

	@Override
	public void delete() {
		System.out.println("Invoice data deleted successfully");
	}

}
