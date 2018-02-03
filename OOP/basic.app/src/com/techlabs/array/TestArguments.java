package com.techlabs.array;

public class TestArguments {
	
	public static void main(String[] developerNames)
	{
		//System.out.println(developerNames.length);
		
		if(developerNames.length!=0)
			for(String dev:developerNames)
				System.out.println("Hello "+dev);
		else
			System.out.println("No argument is found.");
	}
}
