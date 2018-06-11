package com.techlabs.html.dom;

public class Control implements ITag {
	
	private String name;

	public Control(String name) {
		this.name = name;
	}

	@Override
	public void display(int indent) {
		System.out.println("\t<"+this.name+">\t</"+this.name+">");
	}
	
	

}
