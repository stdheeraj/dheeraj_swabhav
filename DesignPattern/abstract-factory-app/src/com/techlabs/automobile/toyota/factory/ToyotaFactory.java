package com.techlabs.automobile.toyota.factory;

import com.techlabs.automobile.factory.IAutoFactory;
import com.techlabs.automobile.factory.IAutomobile;

public class ToyotaFactory implements IAutoFactory {

	@Override
	public IAutomobile makeHatchBack() {
		return new ToyotaHatchBack();
	}

	@Override
	public IAutomobile makeSedan() {
		return new ToyotaSedan();
	}

	@Override
	public IAutomobile makeSuv() {
		return new ToyotaSuv();
	}


}
