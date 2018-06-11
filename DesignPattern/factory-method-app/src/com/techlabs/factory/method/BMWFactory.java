package com.techlabs.factory.method;

public class BMWFactory implements IAutoFactory {

	@Override
	public IAutomobile make() {
		return new BMW();
	}

}
