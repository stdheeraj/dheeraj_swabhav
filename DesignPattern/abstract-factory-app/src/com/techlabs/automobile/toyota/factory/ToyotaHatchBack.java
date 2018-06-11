package com.techlabs.automobile.toyota.factory;

import com.techlabs.automobile.factory.IAutomobile;

class ToyotaHatchBack implements IAutomobile {

	@Override
	public void start() {
		System.out.println("BMW Hatch Back started.");
	}

	@Override
	public void stop() {
		System.out.println("BMW Hatch Back stopped.");
	}

}
