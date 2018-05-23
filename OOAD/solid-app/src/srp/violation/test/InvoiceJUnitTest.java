package srp.violation.test;

import static org.junit.Assert.*;

import org.junit.Test;

import srp.violation.Invoice;

public class InvoiceJUnitTest {
	
	Invoice invoice=new Invoice(101, "MacBook", 150000, 10);

	@Test
	public void testGetInvoiceNo() {
		assertEquals(invoice.getInvoiceno(), 101);
	}
	
	@Test
	public void testGetInvoiceName() {
		assertEquals(invoice.getName(), "MacBook");
	}
	
	@Test
	public void testGetActualCost() {
		assertEquals(invoice.getCost(), 150000, 0);
	}
	
	@Test
	public void testGetDiscount() {
		assertEquals(invoice.getDiscount(), 10, 0);
	}
	
	@Test
	public void testGetGST() {
		assertEquals(Invoice.getGst(), 12, 0);
	}
	
	
	@Test
	public void testCalculateTax() {
		assertEquals(invoice.calculateTotalCost(), 153000, 0);
	}
	
	

}