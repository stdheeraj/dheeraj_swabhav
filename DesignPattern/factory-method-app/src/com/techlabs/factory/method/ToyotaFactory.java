package com.techlabs.factory.method;

public class ToyotaFactory implements IAutoFactory {

	@Override
	public IAutomobile make() {
		return new Toyota();
	}

}
