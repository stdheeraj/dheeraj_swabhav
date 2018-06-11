package com.techlabs.automobile.audi.factory;

import com.techlabs.automobile.factory.IAutoFactory;
import com.techlabs.automobile.factory.IAutomobile;

public class AudiFactory implements IAutoFactory {

	@Override
	public IAutomobile makeHatchBack() {
		return new AudiHatchBack();
	}

	@Override
	public IAutomobile makeSedan() {
		return new AudiSedan();
	}

	@Override
	public IAutomobile makeSuv() {
		return new AudiSuv();
	}


}
