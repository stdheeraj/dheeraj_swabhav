package com.techlabs.movies;

public class File implements IStorageItem {
	
	private String name;
	private int size;
	private String extension;

	public File(String name, int size, String extension) {
		this.name = name;
		this.size = size;
		this.extension = extension;
	}

	@Override
	public void display(int indent) {
		System.out.println("\t"+this.name+"."+this.extension+"("+this.size+" MB)");
	}

}
