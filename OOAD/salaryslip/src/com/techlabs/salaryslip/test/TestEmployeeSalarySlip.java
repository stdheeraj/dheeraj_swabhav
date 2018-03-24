package com.techlabs.salaryslip.test;

import com.techlabs.salaryslip.Analyst;
import com.techlabs.salaryslip.Developer;
import com.techlabs.salaryslip.EmployeePaySlip;
import com.techlabs.salaryslip.Manager;

public class TestEmployeeSalarySlip {
	public static void main(String[] args) {
		
		EmployeePaySlip eps= new EmployeePaySlip();
		
		System.out.println("Pay Slip of Manager ->");
		eps.printPaySlip(new Manager(101,"John", 35000));
		
		System.out.println("\nPay Slip of Developer ->");
		eps.printPaySlip(new Developer(201, "Smith", 25000));
		
		System.out.println("\nPay Slip of Analyst ->");
		eps.printPaySlip(new Analyst(301, "Gina", 15000));
		
	}
}
