package dip.violation.test;

import dip.violation.LogType;
import dip.violation.TaxCalculator;

public class TestTaxCalculator {

	public static void main(String[] args) {

		TaxCalculator taxcal = new TaxCalculator(LogType.XML);
		System.out.println("Tax = " + taxcal.calculateTax(1000, 0));

	}

}
