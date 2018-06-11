package com.techlabs.automobile.audi.factory;

import com.techlabs.automobile.factory.IAutomobile;

class AudiHatchBack implements IAutomobile {

	@Override
	public void start() {
		System.out.println("Audi Hatch Back started.");
	}

	@Override
	public void stop() {
		System.out.println("Audi Hatch Back stopped.");
	}

}
