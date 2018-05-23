package dip.violation;

public class TaxCalculator {

	private LogType logType;

	public TaxCalculator(LogType logType) {
		this.logType = logType;
	}

	public float calculateTax(int a, int b) {
		float r = 0;
		try {
			r = a / b;
		} catch (Exception e) {
			if (this.logType.equals(LogType.Email)) {
				EmailLogger email = new EmailLogger();
				email.log(e);
			}
			if (this.logType.equals(LogType.XML)) {
				XmlLogger xml = new XmlLogger();
				xml.log(e);
			}
		}
		return r;
	}

}
