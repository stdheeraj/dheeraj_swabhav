package com.techlabs.movies;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IStorageItem {
	
	private String name;
	private List<IStorageItem> contents;

	public Folder(String name) {
		this.name = name;
		this.contents=new ArrayList<IStorageItem>();
	}
	
	public void addItem(IStorageItem item){
		this.contents.add(item);
	}

	@Override
	public void display(int indent) {
		System.out.println("\t"+this.name);
		
		for (IStorageItem item : contents) {
			
				for(int i=0;i<indent;i++)
					System.out.print("\t");
				
				if(item instanceof Folder)
					item.display(indent+1);
				else
					item.display(indent);
		}
	}

}
