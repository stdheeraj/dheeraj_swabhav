package com.techlabs.automobile.factory.test;

import com.techlabs.automobile.audi.factory.AudiFactory;
import com.techlabs.automobile.factory.IAutoFactory;
import com.techlabs.automobile.factory.IAutomobile;

public class TestAutomobile {

	public static void main(String[] args) {

		IAutoFactory f = new AudiFactory();

		//IAutomobile auto = f.makeHatchBack();
		IAutomobile auto = f.makeSedan();
		auto.start();
		auto.stop();
		System.out.println(auto.getClass());

	}

}
