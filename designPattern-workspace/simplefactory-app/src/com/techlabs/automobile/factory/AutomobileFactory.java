package com.techlabs.automobile.factory;

public class AutomobileFactory {
	
	private static AutomobileFactory automobile;
	
	private AutomobileFactory(){
		System.out.println("Automobile factory created.");
	}
	
	public static AutomobileFactory getInstance(){
		if(automobile==null)
			automobile=new AutomobileFactory();
		return automobile;
	}
	
	public IAutomobile make(AutoType automobile){
		if(automobile==AutoType.Audi)
			return new Audi();
		if(automobile==AutoType.BMW)
			return new BMW();
		if(automobile==AutoType.Audi)
			return new Toyota();
		return null;
	}

}
