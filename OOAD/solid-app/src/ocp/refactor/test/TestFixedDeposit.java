package ocp.refactor.test;

import ocp.refactor.FixedDeposit;
import ocp.refactor.HoliRate;
import ocp.refactor.IFestivalRate;

public class TestFixedDeposit {

	public static void main(String[] args) {

		IFestivalRate rate = new HoliRate();
		FixedDeposit fixedDeposit = new FixedDeposit(101, "Dheeraj", 10000, 2, rate);
		System.out.println("Simple Interest = " + fixedDeposit.calculateSimpleInterest() + "$");

	}

}
