package com.techlabs.automobile.audi.factory;

import com.techlabs.automobile.factory.IAutomobile;

class AudiSedan implements IAutomobile {

	@Override
	public void start() {
		System.out.println("Audi Sedan started.");
	}

	@Override
	public void stop() {
		System.out.println("Audi Sedan stopped.");
	}

}
