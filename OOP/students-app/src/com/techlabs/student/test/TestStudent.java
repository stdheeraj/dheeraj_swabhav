package com.techlabs.student.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.techlabs.student.Student;

public class TestStudent {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int ch;

		do {
			System.out.println("Enter your choice =>"
					+ " 1 : add student details"
					+ "\t2 : display student details\t3 : exit");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				addStudent();
				break;
			case 2:
				displayStudent();
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid Choice");
			}
		} while (ch != 3);
		sc.close();
	}

	private static void addStudent() {
		
		Student s = new Student();
		
		System.out.println("Enter =>\n Roll No || Name || Stream || Division ");
		s.setRollno(sc.nextInt());
		s.setName(sc.next());
		s.setStream(sc.next());
		s.setDiv(sc.next());
		
		try {
			File f = new File("src/data/students.ser");
			if (f.length() != 0) {
				
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(f));
				
				Student stemp = (Student) ois.readObject();
				ArrayList<Student> sl = new ArrayList<Student>();
				while (stemp != null) {
					sl.add(stemp);
					stemp = (Student) ois.readObject();
				}
				ois.close();

				ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(f));
				for (Student st : sl)
					oos.writeObject(st);
				sl.clear();

				oos.writeObject(s);
				oos.writeObject(null);
			} else {
				ObjectOutputStream oos = new ObjectOutputStream(
						new FileOutputStream(f));
				oos.writeObject(s);
				oos.writeObject(null);
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void displayStudent() {
		try {
			
			File f = new File("src/data/students.ser");
			
			if (f.length() != 0) {
				
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(f));
				
				Student s = (Student) ois.readObject();
				System.out
						.println("Details =>\n\tRoll_No |Name\t|Stream\t|Division");
				System.out.println("\t---------------------------------");
				while (s != null) {
					System.out.println("\t" + s.getRollno() + "\t|"
							+ s.getName() + "\t|" + s.getStream() + "\t|"
							+ s.getDiv());
					s = (Student) ois.readObject();
				}
				ois.close();
				
			} else
				System.out.println("student details are not available");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}