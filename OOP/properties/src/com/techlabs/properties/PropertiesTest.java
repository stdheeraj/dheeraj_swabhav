package com.techlabs.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		OutputStream output = null;
		InputStream input = null;
		
		try {

			output = new FileOutputStream("data/student.txt");

			p.setProperty("Roll No", "20");
			p.setProperty("Name", "Dheeraj");

			p.store(output, null);

			
			
			input = new FileInputStream("data/student.txt");

			p.load(input);

			System.out.println("Roll No : "+p.getProperty("Roll No"));
			System.out.println("Name : "+p.getProperty("Name"));
			
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null && input != null) {
				try {
					output.close();
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}