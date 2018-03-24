package com.techlabs.crudable.test;

import com.techlabs.crudable.CustomerDB;
import com.techlabs.crudable.DepartmentDB;
import com.techlabs.crudable.ICrudable;
import com.techlabs.crudable.InvoiceDB;

public class TestCrudable {
	
	public static void main(String[] args) {
		doDBOperation(new CustomerDB());
		doDBOperation(new InvoiceDB());
		doDBOperation(new DepartmentDB());
	}
	
	private static void doDBOperation(ICrudable ic){
		System.out.println("Doing DB operation...");
		ic.create();
		ic.read();
		ic.update();
		ic.delete();
	}

}
