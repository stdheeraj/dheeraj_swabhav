package com.techlabs.automobile.bmw.factory;

import com.techlabs.automobile.factory.IAutoFactory;
import com.techlabs.automobile.factory.IAutomobile;

public class BMWFactory implements IAutoFactory {

	@Override
	public IAutomobile makeHatchBack() {
		return new BMWHatchBack();
	}

	@Override
	public IAutomobile makeSedan() {
		return new BMWSedan();
	}

	@Override
	public IAutomobile makeSuv() {
		return new BMWSuv();
	}

	

}
