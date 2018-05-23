package dip.refactor;

public class TaxCalculator {

	private ILogger logger;

	public TaxCalculator(ILogger logger) {
		this.logger = logger;
	}

	public float calculateTax(int a, int b) {
		float r = 0;
		try {
			r = a / b;
		} catch (Exception e) {
			this.logger.log(e);
		}
		return r;
	}

}
