package ocp.violation.test;

import ocp.violation.FestivalType;
import ocp.violation.FixedDeposit;

public class TestFixedDeposit {
	
	public static void main(String[] args) {
		
		FixedDeposit fixedDeposit=new FixedDeposit(101, "Dheeraj", 10000, 2, FestivalType.Holi);
		System.out.println("Simple Interest = "+fixedDeposit.calculateSimpleInterest()+"$");
		
	}

}
