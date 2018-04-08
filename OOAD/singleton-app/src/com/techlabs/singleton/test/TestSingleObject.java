package com.techlabs.singleton.test;

import com.techlabs.singleton.SingleObject;

public class TestSingleObject {
	
	public static void main(String[] args) {

		SingleObject so=SingleObject.getObj();
		so.printMessage();
		
	}

}
