package com.techlabs.interfacepolymorphism;

public class Man implements IMemorable {

	@Override
	public void wish() {
		System.out.println("Man is Wishing..");
	}

	@Override
	public void departy() {
		System.out.println("Man is Departying...");
	}
	
	

}
