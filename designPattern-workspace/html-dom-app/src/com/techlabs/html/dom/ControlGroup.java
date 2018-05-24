package com.techlabs.html.dom;

import java.util.ArrayList;
import java.util.List;

public class ControlGroup implements ITag {
	
	private String name;
	private List<ITag> controls;
	
	public ControlGroup(String name) {
		this.name = name;
		this.controls=new ArrayList<ITag>();
	}
	
	public void addTag(ITag tag){
		this.controls.add(tag);
	}

	@Override
	public void display(int indent) {
		System.out.println("\t<"+this.name+">");
		
		for (ITag tag : controls) {
			
			for(int i=0;i<indent;i++)
				System.out.print("\t");
			
			if(tag instanceof ControlGroup)
				tag.display(indent+1);
			else
				tag.display(indent);
			
		}
		
		for(int i=0;i<indent;i++)
			System.out.print("\t");
		
		System.out.println("</"+this.name+">");
	}

}
