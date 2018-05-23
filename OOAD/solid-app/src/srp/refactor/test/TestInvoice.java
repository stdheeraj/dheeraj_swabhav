package srp.refactor.test;

import srp.refactor.Invoice;
import srp.refactor.InvoiceConsolePrinter;
import srp.refactor.InvoicePrinter;

public class TestInvoice {
	
	public static void main(String[] args) {
		
		Invoice invoice=new Invoice(101, "Laptop", 35000, 15);
		InvoicePrinter printInvoice=new InvoiceConsolePrinter(invoice);
		printInvoice.print();
		
	}

}
