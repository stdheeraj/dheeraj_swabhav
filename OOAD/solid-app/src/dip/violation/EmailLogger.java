package dip.violation;

public class EmailLogger {
	
	public void log(Exception e){
		System.out.println("Error message logging to EMail.");
		System.out.println("Error logged as "+e.getMessage());
	}

}
