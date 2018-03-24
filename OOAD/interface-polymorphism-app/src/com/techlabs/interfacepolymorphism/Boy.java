package com.techlabs.interfacepolymorphism;

public class Boy implements IMemorable,IEmotionable {

	@Override
	public void cry() {
		System.out.println("Boy is crying...");
	}

	@Override
	public void laugh() {
		System.out.println("Boy is laughing...");
	}

	@Override
	public void wish() {
		System.out.println("Boy is wishing...");
	}

	@Override
	public void departy() {
		System.out.println("Boy is departying...");
	}

}
