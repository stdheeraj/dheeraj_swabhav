package com.techlabs.annotations;

public class Foo {
	

	@NeedRefractoring("m1")
	public void m1() {
		System.out.println("Method m1");

	}

	public void m2() {
		System.out.println("Method m2");

	}

	public void m3() {
		System.out.println("Method m3");

	}

	@NeedRefractoring("m4")
	public void m4() {
		System.out.println("Method m4");

	}

}
