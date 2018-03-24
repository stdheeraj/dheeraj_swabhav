package com.techlabs.student.test;

import java.util.HashSet;
import java.util.TreeSet;

import com.techlabs.student.Student;

public class TestSet {

	public static void main(String[] agrs) {
		HashSet<Student> hs = new HashSet<Student>();

		Student s1 = new Student(101, "A");
		Student s2 = new Student(101, "A");
		Student s3 = new Student(102, "C");

		hs.add(s1);
		hs.add(s2);
		hs.add(s3);

		System.out.println("Student added to HashSet.");
		System.out.println("Roll No\tName");
		for (Student s : hs) {
			System.out.println(s.getRollNo() + "\t" + s.getName());
		}

		TreeSet<Student> ts = new TreeSet<Student>();

		ts.add(s1);
		ts.add(s2);
		ts.add(s3);

		System.out.println("\nStudent added to TreeSet.");
		System.out.println("Roll No\tName");
		for (Student s : ts) {
			System.out.println(s.getRollNo() + "\t" + s.getName());
		}
	}

}
