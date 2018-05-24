package com.techlabs.movies;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IStorageItem {
	
	private String name;
	private static int count;
	private List<IStorageItem> contents;

	public Folder(String name) {
		this.name = name;
		this.contents=new ArrayList<IStorageItem>();
	}
	
	public void addItem(IStorageItem item){
		this.contents.add(item);
	}

	@Override
	public void display() {
		System.out.println(this.name);
		count++;
		for (IStorageItem item : contents) {
			
			for(int i=0;i<count;i++)
				System.out.print("\t");
			System.out.print(">");
			item.display();
		}
	}

}
