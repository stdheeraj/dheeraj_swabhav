package com.techlabs.serialize;

import java.io.*;

public class SerializeTest {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.name = "Dheeraj Chaurasia";
		emp.address = "Santacruz, Mumbai, India";
		emp.SSN = 1356;
		emp.number = 2035;

		try {
			FileOutputStream fileOut = new FileOutputStream("a1");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(emp);
			out.close();
			fileOut.close();
			System.out.printf("Data Is Serialized");
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}