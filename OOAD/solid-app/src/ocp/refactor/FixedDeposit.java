package ocp.refactor;

public class FixedDeposit {

	private int accountNo;
	private String name;
	private double principle;
	private int duration;
	private IFestivalRate festivalRate;

	public FixedDeposit(int accountNo, String name, double principle,
			int duration, IFestivalRate festivalRate) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.principle = principle;
		this.duration = duration;
		this.festivalRate = festivalRate;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrinciple() {
		return principle;
	}

	public void setPrinciple(double principle) {
		this.principle = principle;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getFestivalRate() {
		return festivalRate.getRate();
	}

	public void setFestivalRate(IFestivalRate festivalRate) {
		this.festivalRate = festivalRate;
	}

	public double calculateSimpleInterest() {
		return (this.getPrinciple() * this.getDuration()
				* this.getFestivalRate() / 100);
	}

}
