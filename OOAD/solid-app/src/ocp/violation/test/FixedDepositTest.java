package ocp.violation.test;

import static org.junit.Assert.*;
import ocp.violation.FestivalType;
import ocp.violation.FixedDeposit;

import org.junit.Test;

public class FixedDepositTest {
	
	FixedDeposit fd=new FixedDeposit(101, "Dheeraj", 10000, 2, FestivalType.Holi);
	
	@Test
	public void testAttributes() {
		assertEquals(fd.getAccountNo(), 101);
		assertEquals(fd.getName(), "Dheeraj");
		assertEquals(fd.getPrinciple(), 10000, 0);
		assertEquals(fd.getDuration(), 2);
		assertEquals(fd.getFestival(), FestivalType.Holi);
	}
	
	@Test
	public void testCalculateRateOfInterest() {
		assertEquals(fd.calculateRateOfInterest(), 8, 0);
	}
	
	@Test
	public void testCalculateSimpleInterest() {
		assertEquals(fd.calculateSimpleInterest(), 1600, 0);
	}


}
