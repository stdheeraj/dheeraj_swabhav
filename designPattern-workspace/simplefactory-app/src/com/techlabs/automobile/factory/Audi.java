package com.techlabs.automobile.factory;

public class Audi implements IAutomobile {

	@Override
	public void start() {
		System.out.println("Audi start.");
	}

	@Override
	public void stop() {
		System.out.println("Audi stop.");
	}

}
