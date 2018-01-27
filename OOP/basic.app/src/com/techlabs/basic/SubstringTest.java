package com.techlabs.basic;



public class SubstringTest {
	public static void main(String agrs[])
	{
		
		String s1="www.swabhavtechlabs.com?developer=Prashad";
		
		System.out.print("Domain is ");
		System.out.println(s1.substring(s1.indexOf(".")+1, s1.lastIndexOf("."))+" .");
		
		System.out.print("Developer is ");
		System.out.println(s1.substring(s1.indexOf("=")+1)+" .");
		
	}

}
