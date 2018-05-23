package srp.violation;

public class Invoice {

	private int invoiceno;
	private String name;
	private double cost;
	private float discount;
	private static final float GST = 12;

	public Invoice(int invoiceno, String name, double cost, float discount) {
		this.invoiceno = invoiceno;
		this.name = name;
		this.cost = cost;
		this.discount = discount;
	}
	
	public void setInvoiceno(int invoiceno) {
		this.invoiceno = invoiceno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	public int getInvoiceno() {
		return invoiceno;
	}

	public String getName() {
		return name;
	}

	public double getCost() {
		return cost;
	}

	public float getDiscount() {
		return discount;
	}

	public static float getGst() {
		return GST;
	}

	private double calculateDiscount() {
		return (this.cost * this.discount / 100);
	}

	private double calculateTax() {
		return (this.cost * GST / 100);
	}

	public double calculateTotalCost() {
		return (this.getCost() - this.calculateDiscount() + this.calculateTax());
	}

	public void printInvoice() {
		System.out.println("Invoice Details ->");
		System.out.println("Name      :" + this.getName());
		System.out.println("Cost      :" + this.getCost() + "$");
		System.out.println("Discount  :" + this.calculateDiscount() + "$");
		System.out.println("GST       :" + this.calculateTax() + "$");
		System.out.println("Total cost:" + this.calculateTotalCost() + "$");
	}

}
