package dip.violation;

public class XmlLogger {
	
	public void log(Exception e){
		System.out.println("Error message logging to XML file.");
		System.out.println("Error logged as "+e.getMessage());
	}

}
