package com.techlabs.singleton;


public class SingleObject {

	
	private static SingleObject obj = new SingleObject();
	
	private SingleObject() {
	}
	
	public static SingleObject getObj(){
    	return obj;
	}
	
	public void printMessage(){
		System.out.println("This is singleton pattern.");
	}

}