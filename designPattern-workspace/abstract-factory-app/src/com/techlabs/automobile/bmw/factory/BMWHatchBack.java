package com.techlabs.automobile.bmw.factory;

import com.techlabs.automobile.factory.IAutomobile;

class BMWHatchBack implements IAutomobile {

	@Override
	public void start() {
		System.out.println("BMW Hatch Back started.");
	}

	@Override
	public void stop() {
		System.out.println("BMW Hatch Back stopped.");
	}

}
