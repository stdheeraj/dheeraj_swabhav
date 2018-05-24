package com.techlabs.automobile.toyota.factory;

import com.techlabs.automobile.factory.IAutomobile;

class ToyotaSedan implements IAutomobile {

	@Override
	public void start() {
		System.out.println("BMW Sedan started.");
	}

	@Override
	public void stop() {
		System.out.println("BMW Sedan stopped.");
	}

}
