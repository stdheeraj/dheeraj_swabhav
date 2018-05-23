package dip.refactor.test;

import dip.refactor.EmailLogger;
import dip.refactor.ILogger;
import dip.refactor.TaxCalculator;
import dip.refactor.XMLLooger;

public class TestTaxCalculator {

	public static void main(String[] args) {

		// ILogger log=new EmailLogger();
		ILogger log = new XMLLooger();

		TaxCalculator calTax = new TaxCalculator(log);
		System.out.println(calTax.calculateTax(1000, 0));
	}
}
