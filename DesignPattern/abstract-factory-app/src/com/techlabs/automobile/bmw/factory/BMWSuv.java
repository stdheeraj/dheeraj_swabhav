package com.techlabs.automobile.bmw.factory;

import com.techlabs.automobile.factory.IAutomobile;

class BMWSuv implements IAutomobile {

	@Override
	public void start() {
		System.out.println("BMW Suv started.");
	}

	@Override
	public void stop() {
		System.out.println("BMW Suv stopped.");
	}

}
