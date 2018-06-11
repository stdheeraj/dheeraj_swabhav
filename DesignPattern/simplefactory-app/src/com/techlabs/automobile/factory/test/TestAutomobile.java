package com.techlabs.automobile.factory.test;

import com.techlabs.automobile.factory.AutoType;
import com.techlabs.automobile.factory.AutomobileFactory;
import com.techlabs.automobile.factory.IAutomobile;

public class TestAutomobile {
	
	public static void main(String[] args) {
		
		AutomobileFactory f=AutomobileFactory.getInstance();
		IAutomobile auto=f.make(AutoType.BMW);
		auto.start();
		auto.stop();
		System.out.println(auto.getClass());
		
	}

}
