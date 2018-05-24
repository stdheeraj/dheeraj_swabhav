package com.techlabs.automobile.bmw.factory;

import com.techlabs.automobile.factory.IAutomobile;

class BMWSedan implements IAutomobile {

	@Override
	public void start() {
		System.out.println("BMW Sedan started.");
	}

	@Override
	public void stop() {
		System.out.println("BMW Sedan stopped.");
	}

}
