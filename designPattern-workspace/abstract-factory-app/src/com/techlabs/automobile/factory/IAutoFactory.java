package com.techlabs.automobile.factory;

public interface IAutoFactory {
	
	public IAutomobile makeHatchBack();
	public IAutomobile makeSedan();
	public IAutomobile makeSuv();

}
