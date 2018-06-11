package com.techlabs.automobile.toyota.factory;

import com.techlabs.automobile.factory.IAutomobile;

class ToyotaSuv implements IAutomobile {

	@Override
	public void start() {
		System.out.println("BMW Suv started.");
	}

	@Override
	public void stop() {
		System.out.println("BMW Suv stopped.");
	}

}
