package com.techlabs.interfaceclass;

interface Bank {
	float rateOfInterest();
}

class SBI implements Bank {
	public float rateOfInterest() {
		return 9.15f;
	}
}

class PNB implements Bank {
	public float rateOfInterest() {
		return 9.7f;
	}
}

class TestInterface {
	public static void main(String[] args) {
		Bank b1 = new SBI();
		System.out.println("ROI(SBI): " + b1.rateOfInterest());
		Bank b2 = new PNB();
		System.out.println("ROI(PNB): " + b2.rateOfInterest());

	}
}