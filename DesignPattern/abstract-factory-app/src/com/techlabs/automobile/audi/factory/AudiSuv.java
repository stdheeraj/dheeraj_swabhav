package com.techlabs.automobile.audi.factory;

import com.techlabs.automobile.factory.IAutomobile;

class AudiSuv implements IAutomobile {

	@Override
	public void start() {
		System.out.println("Audi Suv started.");
	}

	@Override
	public void stop() {
		System.out.println("Audi Suv stopped.");
	}

}
