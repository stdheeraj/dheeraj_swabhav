package com.techlabs.factory.method;

public class AudiFactory implements IAutoFactory {

	@Override
	public IAutomobile make() {
		return new Audi();
	}

}
