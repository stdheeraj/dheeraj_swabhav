package com.techlabs.iteratestudent.test;

import com.techlabs.iteratestudent.Students;

public class TestStudent {

	public static void main(String[] args) {

		Students sl = new Students(3);

		sl.add(0, "Dheeraj");
		sl.add(1, "Prasad");
		sl.add(2, "Vipul");

		for (String s : sl)
			System.out.println(s);

	}

}