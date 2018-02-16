package com.techlabs.annotations;

public class Foo {
	

	@NeedRefractoring()
	public void m1() {
		System.out.println("Class m1");

	}

	public void m2() {
		System.out.println("class m2");

	}

	public void m3() {
		System.out.println("Class m3");

	}

	@NeedRefractoring()
	public void m4() {
		System.out.println("Class m4");

	}

}
