package srp.refactor;

public class InvoiceConsolePrinter implements InvoicePrinter {
	
	private Invoice invoice;
	
	public InvoiceConsolePrinter(Invoice invoice) {
		this.invoice=invoice;
	}

	@Override
	public void print() {
		
		System.out.println("Invoice Details ->");
		System.out.println("Name      :" + this.invoice.getName());
		System.out.println("Cost      :" + this.invoice.getCost() + "$");
		System.out.println("Discount  :" + this.invoice.getDiscount() + "$");
		System.out.println("GST       :" + Invoice.getGst() + "$");
		System.out.println("Total cost:" + this.invoice.calculateTotalCost() + "$");

	}

}
