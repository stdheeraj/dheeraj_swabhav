package com.techlabs.automobile.factory;

public class Toyota implements IAutomobile {

	@Override
	public void start() {
		System.out.println("Toyota start.");
	}

	@Override
	public void stop() {
		System.out.println("Toyota stop.");
	}

}
