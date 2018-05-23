package ocp.violation;

public class FixedDeposit {
	
	private int accountNo;
	private String name;
	private double principle;
	private int duration;
	private FestivalType festival;
	
	public FixedDeposit(int accountNo, String name, double principle,
			int duration, FestivalType festival) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.principle = principle;
		this.duration = duration;
		this.festival = festival;
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

	public FestivalType getFestival() {
		return festival;
	}

	public void setFestival(FestivalType festival) {
		this.festival = festival;
	}
	
	public double calculateRateOfInterest(){
		double rateOfInterest=0;
		
		if(this.getFestival().equals(FestivalType.New_Year))
			rateOfInterest=9;
		if(this.getFestival().equals(FestivalType.Holi))
			rateOfInterest=8;
		if(this.getFestival().equals(FestivalType.Normal))
			rateOfInterest=6.5;
		
		return rateOfInterest;
	}
	
	public double calculateSimpleInterest(){
		return (this.getPrinciple()*this.getDuration()*this.calculateRateOfInterest()/100);
	}

}
